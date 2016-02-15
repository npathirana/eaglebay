package com.eagle.portal.web.service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.Seller;

public interface SellerService extends GenericService<Seller>{

	Seller save(Seller obj) throws ServiceException;

}
