package com.eagle.commons.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.eagle.commons.dao.SellerDao;
import com.eagle.commons.domain.Seller;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.SellerService;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class SellerServiceImpl extends GenericServiceImpl<Seller> implements SellerService{

	@Autowired
	private SellerDao sellerDao;
	
	@PostConstruct
    void init() {
        init(Seller.class, sellerDao);
    }
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public Seller save(Seller obj) throws ServiceException {

        if (obj != null) {
            if (obj.getId() == null) {
                this.add(obj);
            } else {
                this.edit(obj);
            }
        } else {
            throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
        }
        return obj;
    }
	
	public Seller add(Seller seller) throws ServiceException {
        validateConstraints(seller);

        try {
        	sellerDao.add(seller);
            //do other sub objects related things here..
            return seller;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    public Seller edit(Seller seller) throws ServiceException {

        try {
            sellerDao.modify(seller);
            //do other sub objects related things here..
            return seller;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
