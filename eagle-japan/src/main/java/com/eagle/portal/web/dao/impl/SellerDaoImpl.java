package com.eagle.portal.web.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.SellerDao;
import com.eagle.portal.web.domain.Seller;
import com.eagle.user.domain.UserPermission;

@Repository
public class SellerDaoImpl extends GenericDaoImpl<Seller> implements SellerDao{

	protected static Logger logger = LoggerFactory.getLogger(SellerDaoImpl.class);
	
	protected SellerDaoImpl() {
		super(Seller.class);
	}
	
}
