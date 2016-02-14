package com.eagle.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.commons.dao.util.NotNullOrBlankStringPropertySelector;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.user.dao.RolePermissionDao;
import com.eagle.user.domain.Permission;
import com.eagle.user.domain.RolePermission;
import com.eagle.user.domain.User;

@Service
public class RolePermissionDaoImpl extends GenericDaoImpl<RolePermission> implements RolePermissionDao{

	protected static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired
    private NotNullOrBlankStringPropertySelector notNullOrBlankStringPropertySelector;
	
    public RolePermissionDaoImpl() {
        super(RolePermission.class);
    }
    
    @Override
    public List<RolePermission> getByRoleId(int roleId) throws DataAccessException{
    	try {
            return (List<RolePermission>) sessionFactory.getCurrentSession()
                    .getNamedQuery("RolePermission.findByRoleId")
                    .setParameter("roleId", roleId)
                    .list();
        } catch (Exception e) {
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

}
