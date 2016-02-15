package com.eagle.portal.web.service;

import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.domain.Country;
import com.eagle.commons.exception.ServiceException;

/**
 * Country Service class
 * @see CountryService
 * @see com.eagle.commons.service.GenericService
 * @see com.eagle.commons.service.impl.GenericServiceImpl
 * @author Harshana Samaranayake
 */
public interface CountryService extends GenericService<Country> {

    Country save(Country obj) throws ServiceException;
}
