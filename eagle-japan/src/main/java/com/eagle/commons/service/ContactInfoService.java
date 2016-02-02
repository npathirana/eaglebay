package com.eagle.commons.service;

import com.eagle.commons.domain.ContactInfo;
import com.eagle.commons.domain.Seller;
import com.eagle.commons.exception.ServiceException;

public interface ContactInfoService extends GenericService<ContactInfo>{

	ContactInfo save(ContactInfo obj) throws ServiceException;

}
