package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.CountryDao;
import com.eagle.commons.domain.Country;
import org.springframework.stereotype.Repository;

/**
 * Country Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see com.eagle.commons.dao.CountryDao
 * @author Harshana Samaranayake
 */
@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao {
    protected CountryDaoImpl() {
        super(Country.class);
    }
}
