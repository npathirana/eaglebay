package com.eagle.portal.web.dao.impl;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.BuyerDao;
import com.eagle.portal.web.domain.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see BuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class BuyerDaoImpl extends GenericDaoImpl<Buyer> implements BuyerDao {

    protected static Logger logger = LoggerFactory.getLogger(BuyerDaoImpl.class);

    protected BuyerDaoImpl() {
        super(Buyer.class);
    }
}
