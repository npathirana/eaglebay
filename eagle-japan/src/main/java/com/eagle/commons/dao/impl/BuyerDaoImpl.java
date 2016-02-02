package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.BuyerDao;
import com.eagle.commons.domain.Buyer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see com.eagle.commons.dao.BuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class BuyerDaoImpl extends GenericDaoImpl<Buyer> implements BuyerDao {

    protected static Logger logger = LoggerFactory.getLogger(BuyerDaoImpl.class);

    protected BuyerDaoImpl() {
        super(Buyer.class);
    }
}
