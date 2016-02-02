package com.eagle.commons.service.impl;

import com.eagle.commons.dao.CorporateBuyerDao;
import com.eagle.commons.domain.CorporateBuyer;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.CorporateBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Corporate Buyer Service class
 * @see com.eagle.commons.service.CorporateBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
@Service
@Transactional(value = "transactionManager",readOnly = true,propagation = Propagation.REQUIRED)
public class CorporateBuyerServiceImpl extends GenericServiceImpl<CorporateBuyer> implements CorporateBuyerService {
    @Autowired
    private CorporateBuyerDao corporateBuyerDao;

    @PostConstruct
    void init(){
        init(CorporateBuyer.class,corporateBuyerDao);
    }

    @Override
    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public CorporateBuyer save(CorporateBuyer obj) throws ServiceException {
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
    public CorporateBuyer add(CorporateBuyer obj) throws ServiceException {
        validateConstraints(obj);

        try {
            corporateBuyerDao.add(obj);
            //do other sub objects related things here..
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    @Override
    public CorporateBuyer edit(CorporateBuyer obj) throws ServiceException {
        try {
            corporateBuyerDao.modify(obj);
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
