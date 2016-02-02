package com.eagle.commons.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.commons.dao.ContactInfoDao;
import com.eagle.commons.dao.SellerDao;
import com.eagle.commons.domain.ContactInfo;
import com.eagle.commons.domain.Seller;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.ContactInfoService;
import com.eagle.commons.service.SellerService;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class ContactInfoServiceImpl extends GenericServiceImpl<ContactInfo> implements ContactInfoService{

	@Autowired
	private ContactInfoDao contactInfoDao;
	
	@PostConstruct
    void init() {
        init(ContactInfo.class, contactInfoDao);
    }
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public ContactInfo save(ContactInfo obj) throws ServiceException {

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
	
	public ContactInfo add(ContactInfo contactInfo) throws ServiceException {
        validateConstraints(contactInfo);

        try {
        	contactInfoDao.add(contactInfo);
            //do other sub objects related things here..
            return contactInfo;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    public ContactInfo edit(ContactInfo contactInfo) throws ServiceException {

        try {
        	contactInfoDao.modify(contactInfo);
            return contactInfo;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
