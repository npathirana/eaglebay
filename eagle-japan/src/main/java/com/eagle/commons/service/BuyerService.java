package com.eagle.commons.service;

import com.eagle.commons.domain.Buyer;
import com.eagle.commons.exception.ServiceException;

/**
 * Buyer Service class
 * @see com.eagle.commons.service.BuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface BuyerService extends GenericService<Buyer>{

    Buyer save(Buyer obj) throws ServiceException;
}
