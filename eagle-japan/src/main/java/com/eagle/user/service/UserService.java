package com.eagle.user.service;

import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import com.eagle.user.domain.User;

import java.util.List;

/**
 * Created by sylenthira on 2/24/15.
 */
public interface UserService extends GenericService<User> {

    User getByEmail(String username) throws ServiceException;

    User save(User obj) throws ServiceException;

    void delete(int id) throws ServiceException;

    void delete(List<Integer> idList) throws ServiceException;

}
