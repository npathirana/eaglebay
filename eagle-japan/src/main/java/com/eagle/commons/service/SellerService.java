package com.eagle.commons.service;

import com.eagle.commons.domain.Seller;
import com.eagle.commons.exception.ServiceException;

public interface SellerService extends GenericService<Seller>{

	Seller save(Seller obj) throws ServiceException;

}
