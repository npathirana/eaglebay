package com.eagle.portal.web.service;

import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.IndividualBuyer;
import com.eagle.commons.exception.ServiceException;

/**
 * Individual Buyer Service class
 * @see IndividualBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface IndividualBuyerService extends GenericService<IndividualBuyer> {

    IndividualBuyer save(IndividualBuyer obj) throws ServiceException;
}
