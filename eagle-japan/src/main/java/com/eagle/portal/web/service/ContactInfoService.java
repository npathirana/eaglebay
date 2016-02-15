package com.eagle.portal.web.service;

import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.ContactInfo;
import com.eagle.commons.exception.ServiceException;

/**
 * Contact Information Service class
 * @see ContactInfoService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface ContactInfoService extends GenericService<ContactInfo> {

    ContactInfo save(ContactInfo obj) throws ServiceException;
}
