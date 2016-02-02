package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.CorporateBuyerDao;
import com.eagle.commons.domain.CorporateBuyer;
import org.springframework.stereotype.Repository;

/**
 * Corporate Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see com.eagle.commons.dao.CorporateBuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class CorporateBuyerDaoImpl extends GenericDaoImpl<CorporateBuyer> implements CorporateBuyerDao {
    protected CorporateBuyerDaoImpl() {
        super(CorporateBuyer.class);
    }
}
