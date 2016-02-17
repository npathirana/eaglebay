package com.eagle.portal.web.service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.ContactInfo;

public interface ContactInfoService extends GenericService<ContactInfo>{

	ContactInfo save(ContactInfo obj) throws ServiceException;

}
