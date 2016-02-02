package com.eagle.commons.service.impl;

import com.eagle.commons.dao.BuyerDao;
import com.eagle.commons.dao.CountryDao;
import com.eagle.commons.domain.Buyer;
import com.eagle.commons.domain.Country;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.BuyerService;
import com.eagle.commons.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Buyer Service class
 * @see com.eagle.commons.service.BuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
@Service
@Transactional(value = "transactionManager",readOnly = true,propagation = Propagation.REQUIRED)
public class BuyerServiceImpl extends GenericServiceImpl<Buyer> implements BuyerService {
    @Autowired
    private BuyerDao buyerDao;

    @PostConstruct
    void init(){
        init(Buyer.class,buyerDao);
    }

    @Override
    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public Buyer save(Buyer obj) throws ServiceException {
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
    public ServiceException translateException(DataAccessException de) {
        return null;
    }

    @Override
    public Buyer add(Buyer obj) throws ServiceException {
        validateConstraints(obj);

        try {
            buyerDao.add(obj);
            //do other sub objects related things here..
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    @Override
    public Buyer edit(Buyer obj) throws ServiceException {
        try {
            buyerDao.modify(obj);
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}