package com.eagle.user.dao;

import java.util.List;

import com.eagle.commons.dao.GenericDao;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.user.domain.RolePermission;

public interface RolePermissionDao  extends GenericDao<RolePermission>{

	List<RolePermission> getByRoleId(int roleId) throws DataAccessException;

}
