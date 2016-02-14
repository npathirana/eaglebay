package com.eagle.portal.web.main.service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.main.domain.ContactInfo;
import com.eagle.portal.web.main.domain.Seller;

public interface ContactInfoService extends GenericService<ContactInfo>{

	ContactInfo save(ContactInfo obj) throws ServiceException;

}
