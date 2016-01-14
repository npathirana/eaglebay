package com.eagle.commons.dao.impl;

import com.eagle.commons.dao.GenericDao;
import com.eagle.commons.exception.DataAccessException;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
    private static final Logger logger = LoggerFactory.getLogger(GenericDaoImpl.class);
    private final Class<? extends T> type;
    @Autowired
    @Qualifier("sessionFactory")
    protected SessionFactory sessionFactory;

    protected GenericDaoImpl(Class<? extends T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public T getById(Serializable id) throws DataAccessException {
        try {
            return (T) sessionFactory.getCurrentSession().get(type, id);
        } catch (Exception e) {
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);

        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() throws DataAccessException {
        try {
            return (List<T>) sessionFactory.getCurrentSession().createQuery(
                    "from " + type.getName()).list();
        } catch (Exception e) {
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

    public List<Object[]> getList(int offset, int size) throws DataAccessException {
        logger.debug("Calling GenericDaoImpl.getList: returning empty list");
        return new ArrayList<>(0);
    }

    public void delete(T obj) throws DataAccessException {
        try {
            sessionFactory.getCurrentSession().delete(obj);
        } catch (Exception e) {
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }

    }

    public void add(T obj) throws DataAccessException {
        try {
            sessionFactory.getCurrentSession().save(obj);
        } catch (Exception e) {
            logger.debug("Exception", e);
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

    public void modify(T obj) throws DataAccessException {
        try {
            sessionFactory.getCurrentSession().merge(obj);
        } catch (Exception e) {
            logger.debug("error - calling default method: modify ({})", e);
            throw new DataAccessException(DataAccessException.PROCESSING_FAILED, e.getMessage(), e);
        }

    }

    public void initCollections(List list) {
        Hibernate.initialize(list);
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
