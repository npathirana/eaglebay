package com.eagle.commons.service;

import com.eagle.commons.exception.DataAccessException;
import com.eagle.commons.exception.ServiceException;

import java.util.List;

public interface GenericService<T> {

    ServiceException translateException(DataAccessException de);

    T getById(int id) throws ServiceException;

    T add(T obj) throws ServiceException;

    T edit(T obj) throws ServiceException;

    List<Object[]> getList(int offset, int size) throws ServiceException;

    List<T> getAll() throws ServiceException;

}