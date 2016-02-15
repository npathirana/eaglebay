package com.eagle.portal.web.dao.impl;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.CorporateBuyerDao;
import com.eagle.portal.web.domain.CorporateBuyer;
import org.springframework.stereotype.Repository;

/**
 * Corporate Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see CorporateBuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class CorporateBuyerDaoImpl extends GenericDaoImpl<CorporateBuyer> implements CorporateBuyerDao {
    protected CorporateBuyerDaoImpl() {
        super(CorporateBuyer.class);
    }
}
