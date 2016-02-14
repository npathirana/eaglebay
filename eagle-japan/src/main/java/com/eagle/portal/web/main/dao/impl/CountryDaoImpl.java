package com.eagle.portal.web.main.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.main.dao.CountryDao;
import com.eagle.portal.web.main.domain.Country;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao{

	protected CountryDaoImpl() {
		super(Country.class);
	}

	

}
