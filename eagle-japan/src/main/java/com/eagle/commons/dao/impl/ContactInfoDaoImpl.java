package com.eagle.commons.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.ContactInfoDao;
import com.eagle.commons.domain.ContactInfo;

@Repository
public class ContactInfoDaoImpl extends GenericDaoImpl<ContactInfo> implements ContactInfoDao{

	protected ContactInfoDaoImpl() {
		super(ContactInfo.class);
	}

}
