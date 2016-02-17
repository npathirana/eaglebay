package com.eagle.portal.web.service.impl;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.impl.GenericServiceImpl;
import com.eagle.portal.web.dao.CountryDao;
import com.eagle.portal.web.domain.Country;
import com.eagle.portal.web.service.CountryService;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class CountryServiceImpl extends GenericServiceImpl<Country> implements CountryService{

	@Autowired
	private CountryDao countryDao;
	
	@PostConstruct
    void init() {
        init(Country.class, countryDao);
    }
	
	@Override
	@Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public Country save(Country obj) throws ServiceException {

        if (obj != null) {
            if (obj.getId() == null) {
                this.add(obj);
            } else {
                this.edit(obj);
            }
        } else {
            throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
        }
        return obj;
    }
	
	public Country add(Country country) throws ServiceException {
        validateConstraints(country);

        try {
        	countryDao.add(country);
            //do other sub objects related things here..
            return country;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    public Country edit(Country country) throws ServiceException {

        try {
        	countryDao.modify(country);
            return country;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }
}
