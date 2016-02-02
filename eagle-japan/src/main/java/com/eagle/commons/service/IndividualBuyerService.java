package com.eagle.commons.service;

import com.eagle.commons.domain.Country;
import com.eagle.commons.domain.IndividualBuyer;
import com.eagle.commons.exception.ServiceException;

/**
 * Individual Buyer Service class
 * @see com.eagle.commons.service.IndividualBuyerService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface IndividualBuyerService extends GenericService<IndividualBuyer>{

    IndividualBuyer save(IndividualBuyer obj) throws ServiceException;
}
