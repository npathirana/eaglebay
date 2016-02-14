package com.eagle.user.service.impl;

import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.impl.GenericServiceImpl;
import com.eagle.user.dao.UserDao;
import com.eagle.user.domain.User;
import com.eagle.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class UserServiceImpl extends GenericServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    void init() {
        init(User.class, userDao);
    }

    public User getById(int id) throws ServiceException {
        try {
            return userDao.getById(id);
        } catch (DataAccessException dae) {
            throw translateException(dae);
        } catch (Exception e) {
            throw new ServiceException(ServiceException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

    @Override
    public User getByEmail(String username) throws ServiceException {
        try {
            return userDao.getByEmail(username);
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    @Override
    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public void delete(int id) throws ServiceException {

        try {

            final User user = this.getById(id);

            if (user == null) {
                throw new ServiceException(ServiceException.VALIDATION_FAILED, getMessage("label.afc.error.invalid.resource.access", getMessage("label.user")));
            }

            user.setStatus(User.STATUS_DELETED);
            userDao.modify(user);

        } catch (DataAccessException e) {
            logger.error(e.getMessage(), e);
            throw translateException(e);
        }

    }

    @Override
    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public void delete(List<Integer> idList) throws ServiceException {
        if (idList != null && idList.size() > 0) {
            for (int id : idList) {
                this.delete(id);
            }
        }
    }

    @Transactional(value = "transactionManager", readOnly = false, rollbackFor = ServiceException.class)
    public User save(User obj) throws ServiceException {

        if (obj != null) {
            if (obj.getId() == null) {
                this.add(obj);
            } else {
                this.edit(obj);
            }
        } else {
            throw new ServiceException(ServiceException.VALIDATION_FAILED, "label.error.required.user");
        }
        return obj;
    }


    public User add(User user) throws ServiceException {
        validateConstraints(user);

        try {
            userDao.add(user);
            return user;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }

    public User edit(User user) throws ServiceException {

        try {
            userDao.modify(user);
            //do other sub objects related things here..
            return user;
        } catch (DataAccessException e) {
            throw translateException(e);
        }
    }


}
