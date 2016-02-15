package com.eagle.portal.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.ContactInfoDao;
import com.eagle.portal.web.domain.ContactInfo;

@Repository
public class ContactInfoDaoImpl extends GenericDaoImpl<ContactInfo> implements ContactInfoDao{

	protected ContactInfoDaoImpl() {
		super(ContactInfo.class);
	}

}
