package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.IndividualBuyerDao;
import com.eagle.commons.domain.IndividualBuyer;
import org.springframework.stereotype.Repository;

/**
 * Individual Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see com.eagle.commons.dao.IndividualBuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class IndividualBuyerDaoImpl extends GenericDaoImpl<IndividualBuyer> implements IndividualBuyerDao{
    protected IndividualBuyerDaoImpl() {
        super(IndividualBuyer.class);
    }
}
