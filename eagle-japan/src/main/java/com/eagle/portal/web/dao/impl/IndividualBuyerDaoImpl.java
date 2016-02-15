package com.eagle.portal.web.dao.impl;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.IndividualBuyerDao;
import com.eagle.portal.web.domain.IndividualBuyer;
import org.springframework.stereotype.Repository;

/**
 * Individual Buyer Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see IndividualBuyerDao
 * @author Harshana Samaranayake
 */
@Repository
public class IndividualBuyerDaoImpl extends GenericDaoImpl<IndividualBuyer> implements IndividualBuyerDao{
    protected IndividualBuyerDaoImpl() {
        super(IndividualBuyer.class);
    }
}
