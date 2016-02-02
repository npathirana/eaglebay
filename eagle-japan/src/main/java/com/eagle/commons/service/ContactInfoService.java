package com.eagle.commons.service;

import com.eagle.commons.domain.ContactInfo;
import com.eagle.commons.exception.ServiceException;

/**
 * Contact Information Service class
 * @see com.eagle.commons.service.ContactInfoService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface ContactInfoService extends GenericService<ContactInfo> {

    ContactInfo save(ContactInfo obj) throws ServiceException;
}
