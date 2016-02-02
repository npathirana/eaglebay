package com.eagle.commons.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.CountryDao;
import com.eagle.commons.domain.Country;

@Repository
public class CountryDaoImpl extends GenericDaoImpl<Country> implements CountryDao{

	protected CountryDaoImpl() {
		super(Country.class);
	}

	

}
