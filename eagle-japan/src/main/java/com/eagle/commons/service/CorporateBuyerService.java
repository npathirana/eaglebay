package com.eagle.commons.service;

import com.eagle.commons.domain.CorporateBuyer;
import com.eagle.commons.domain.Country;
import com.eagle.commons.exception.ServiceException;

/**
 * Corporate Buyer Service class
 * @see com.eagle.commons.service.CorporateBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface CorporateBuyerService extends GenericService<CorporateBuyer>{

    CorporateBuyer save(CorporateBuyer obj) throws ServiceException;
}
