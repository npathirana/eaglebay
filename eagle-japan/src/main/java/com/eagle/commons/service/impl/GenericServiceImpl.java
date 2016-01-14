package com.eagle.commons.service.impl;

import com.eagle.commons.dao.GenericDao;
import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;
import com.eagle.commons.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Transactional(value = "transactionManager", readOnly = true, propagation = Propagation.REQUIRED)
public class GenericServiceImpl<T> implements GenericService<T> {

    protected static final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);

    private static Validator validator;
    private static ValidatorFactory factory;
    protected GenericDao<T> genericDao;
    @Qualifier("messageSource")
    @Autowired
    protected MessageSource messageSource;
    private Class<? extends T> type;

    protected GenericServiceImpl() {
        if (factory == null) {
            factory = Validation.buildDefaultValidatorFactory();
            validator = factory.getValidator();
        }
    }

    public String getMessage(String key, Object... params) {
        try {
            return messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        } catch (NoSuchMessageException e) {
            logger.error(e.getMessage(), e);
            return key;
        }
    }

    protected void init(Class<? extends T> type, GenericDao<T> dao) {
        this.type = type;
        this.genericDao = dao;
    }

    protected void validateConstraints(T obj) throws ServiceException {

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);

        if (constraintViolations.size() > 0) {
            String property = constraintViolations.iterator().next().getPropertyPath().toString();
            String error = constraintViolations.iterator().next().getMessage();
            String errorMessage = property + " : " + error;
            throw new ServiceException(ServiceException.CUSTOM_ERROR, errorMessage);
        }
    }

    @Override
    public ServiceException translateException(DataAccessException de) {
        switch (de.getCode()) {
            case DataAccessException.VALIDATION_FAILED:
                return new ServiceException(ServiceException.VALIDATION_FAILED, de.getMessage());
            default:
                return new ServiceException(ServiceException.PROCESSING_FAILED, de.getMessage());
        }
    }

    @Override
    public T getById(int id) throws ServiceException {
        try {
            return genericDao.getById(id);
        } catch (DataAccessException dae) {
            throw translateException(dae);
        } catch (Exception e) {
            throw new ServiceException(ServiceException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }


    @Transactional(readOnly = false)
    @Override
    public T add(T obj) throws ServiceException {
        logger.debug("calling default method: add({})", obj);
        try {
            genericDao.add(obj);
        } catch (DataAccessException dae) {
            throw translateException(dae);
        }
        return obj;
    }

    @Transactional(readOnly = false)
    @Override
    public T edit(T obj) throws ServiceException {
        logger.debug("calling default method: edit({})", obj);
        try {
            genericDao.modify(obj);
        } catch (DataAccessException dae) {
            throw translateException(dae);
        }
        return obj;
    }

    @Override
    public List<Object[]> getList(int offset, int size) throws ServiceException {
        try {
            return genericDao.getList(offset, size);
        } catch (DataAccessException dae) {
            throw translateException(dae);
        } catch (Exception e) {
            throw new ServiceException(ServiceException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

    @Override
    public List<T> getAll() throws ServiceException {
        try {
            return genericDao.getAll();
        } catch (DataAccessException dae) {
            throw translateException(dae);
        } catch (Exception e) {
            throw new ServiceException(ServiceException.PROCESSING_FAILED, e.getMessage(), e);
        }
    }

}
