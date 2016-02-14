package com.eagle.user.dao;


import java.util.List;

import com.eagle.commons.dao.GenericDao;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.user.domain.User;
import com.eagle.user.domain.UserPermission;

/**
 * A custom DAO for accessing data from the database.
 */
public interface UserDao extends GenericDao<User> {

    User getByEmail(String username) throws DataAccessException;

	List<UserPermission> getUserPermissions();

}