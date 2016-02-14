package com.eagle.portal.web.main.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.main.dao.ContactInfoDao;
import com.eagle.portal.web.main.domain.ContactInfo;

@Repository
public class ContactInfoDaoImpl extends GenericDaoImpl<ContactInfo> implements ContactInfoDao{

	protected ContactInfoDaoImpl() {
		super(ContactInfo.class);
	}

}
