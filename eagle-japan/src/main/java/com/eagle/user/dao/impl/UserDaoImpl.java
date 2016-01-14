package com.eagle.user.dao.impl;


import com.eagle.commons.dao.impl.GenericDaoImpl;
import com.eagle.commons.dao.util.NotNullOrBlankStringPropertySelector;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.user.dao.UserDao;
import com.eagle.user.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    protected static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    @Autowired
    private NotNullOrBlankStringPropertySelector notNullOrBlankStringPropertySelector;

    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByEmail(String email) throws DataAccessException {
        try {
            return (User) sessionFactory.getCurrentSession()
                    .getNamedQuery("User.findByEmailStatus")
                    .setParameter("email", email)
                    .setParameter("status", User.STATUS_ACTIVE)
                    .uniqueResult();
        } catch (Exception e) {
            logger.error("User does not exist!");
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

}