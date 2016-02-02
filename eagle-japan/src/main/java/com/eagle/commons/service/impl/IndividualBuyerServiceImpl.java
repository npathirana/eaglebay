package com.eagle.commons.service.impl;

import com.eagle.commons.dao.CorporateBuyerDao;
import com.eagle.commons.dao.IndividualBuyerDao;
import com.eagle.commons.domain.CorporateBuyer;
import com.eagle.commons.domain.IndividualBuyer;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.CorporateBuyerService;
import com.eagle.commons.service.IndividualBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Individual Buyer Service class
 * @see com.eagle.commons.service.IndividualBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
@Service
@Transactional(value = "transactionManager",readOnly = true,propagation = Propagation.REQUIRED)
public class IndividualBuyerServiceImpl extends GenericServiceImpl<IndividualBuyer> implements IndividualBuyerService {
    @Autowired
    private IndividualBuyerDao individualBuyerDao;

    @PostConstruct
    void init(){
        init(IndividualBuyer.class,individualBuyerDao);
    }

    @Override
    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public IndividualBuyer save(IndividualBuyer obj) throws ServiceException {
        if(obj != null){
            if(obj.getId() == null){
                this.add(obj);
            }else{
                this.edit(obj);
            }
        } else {
            throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
        }
        return obj;
    }

    @Override
    public IndividualBuyer add(IndividualBuyer obj) throws ServiceException {
        validateConstraints(obj);

        try {
            individualBuyerDao.add(obj);
            //do other sub objects related things here..
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    @Override
    public IndividualBuyer edit(IndividualBuyer obj) throws ServiceException {
        try {
            individualBuyerDao.modify(obj);
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
