package com.eagle.portal.web.dao.impl;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.portal.web.dao.ContactInfoDao;
import com.eagle.portal.web.domain.ContactInfo;
import org.springframework.stereotype.Repository;

/**
 * Contact Information Data Access object class
 * @see com.eagle.commons.dao.GenericDao
 * @see ContactInfoDao
 * @author Harshana Samaranayake
 */
@Repository
public class ContactInfoDaoImpl extends GenericDaoImpl<ContactInfo> implements ContactInfoDao {
    protected ContactInfoDaoImpl() {
        super(ContactInfo.class);
    }
}
