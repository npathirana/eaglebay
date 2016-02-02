package com.eagle.commons.service;

import com.eagle.commons.domain.Country;
import com.eagle.commons.exception.ServiceException;

/**
 * Country Service class
 * @see com.eagle.commons.service.CountryService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface CountryService extends GenericService<Country>{

    Country save(Country obj) throws ServiceException;
}
