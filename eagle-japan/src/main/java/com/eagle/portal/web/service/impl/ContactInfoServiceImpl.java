package com.eagle.portal.web.service.impl;

import com.eagle.commons.service.impl.GenericServiceImpl;
import com.eagle.portal.web.dao.ContactInfoDao;
import com.eagle.portal.web.domain.ContactInfo;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.portal.web.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * Contact Information Service class
 * @see ContactInfoService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class ContactInfoServiceImpl extends GenericServiceImpl<ContactInfo> implements ContactInfoService {

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

    @Override
    public ContactInfo add(ContactInfo obj) throws ServiceException {
        validateConstraints(obj);

        try {
            contactInfoDao.add(obj);
            //do other sub objects related things here..
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    @Override
    public ContactInfo edit(ContactInfo obj) throws ServiceException {
        try {
            contactInfoDao.modify(obj);
            return obj;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
