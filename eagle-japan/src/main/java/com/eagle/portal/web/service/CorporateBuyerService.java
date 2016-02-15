package com.eagle.portal.web.service;

import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.CorporateBuyer;
import com.eagle.commons.exception.ServiceException;

/**
 * Corporate Buyer Service class
 * @see CorporateBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface CorporateBuyerService extends GenericService<CorporateBuyer> {

    CorporateBuyer save(CorporateBuyer obj) throws ServiceException;
}
