package com.eagle.portal.web.service;

import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.Buyer;
import com.eagle.commons.exception.ServiceException;

/**
 * Buyer Service class
 * @see BuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface BuyerService extends GenericService<Buyer> {

    Buyer save(Buyer obj) throws ServiceException;
}
