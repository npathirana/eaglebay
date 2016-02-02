package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.ContactInfoDao;
import com.eagle.commons.domain.ContactInfo;
import org.springframework.stereotype.Repository;

/**
 * Contact Information Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see com.eagle.commons.dao.ContactInfoDao
 * @author Harshana Samaranayake
 */
@Repository
public class ContactInfoDaoImpl extends GenericDaoImpl<ContactInfo> implements ContactInfoDao {
    protected ContactInfoDaoImpl() {
        super(ContactInfo.class);
    }
}
