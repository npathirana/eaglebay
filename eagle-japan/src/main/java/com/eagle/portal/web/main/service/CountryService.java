package com.eagle.portal.web.main.service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.portal.web.main.domain.Country;

public interface CountryService extends GenericService<Country>{

	Country save(Country obj) throws ServiceException;

}
