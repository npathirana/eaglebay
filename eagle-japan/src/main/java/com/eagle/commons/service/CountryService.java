package com.eagle.commons.service;

import com.eagle.commons.domain.Country;
import com.eagle.commons.exception.ServiceException;

public interface CountryService extends GenericService<Country>{

	Country save(Country obj) throws ServiceException;

}
