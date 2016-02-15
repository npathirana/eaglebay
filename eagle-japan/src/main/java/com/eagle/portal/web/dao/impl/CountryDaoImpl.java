package com.eagle.portal.web.dao.impl;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.CountryDao;
import com.eagle.portal.web.domain.Country;
import org.springframework.stereotype.Repository;

/**
 * Country Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see CountryDao
 * @author Harshana Samaranayake
 */
@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao {
    protected CountryDaoImpl() {
        super(Country.class);
    }
}
