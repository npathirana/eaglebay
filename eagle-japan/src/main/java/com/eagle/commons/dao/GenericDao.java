package com.eagle.commons.dao;


import com.eagle.commons.exception.DataAccessException;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T> {
    /**
     * This method delete given object from the database.
     *
     * @param id - Object id to load
     * @throws DataAccessException - throws if an error occurs
     */
    T getById(Serializable id) throws DataAccessException;

    /**
     * This method queries all the objects
     *
     * @throws DataAccessException - throws if an error occurs
     */
    List<T> getAll() throws DataAccessException;

    /**
     * This method queries objects within specified range
     *
     * @throws DataAccessException - throws if an error occurs
     */
    List<Object[]> getList(int offset, int size) throws DataAccessException;

    /**
     * This method delete given object from the database.
     *
     * @param object - instance of Object class
     * @throws DataAccessException - throws if an error occurs
     */
    void delete(T object) throws DataAccessException;

    /**
     * This method insert a given object to the database.
     *
     * @param object - instance of Object class
     * @throws DataAccessException - throws if an error occurs
     */
    void add(T object) throws DataAccessException;

    /**
     * This method update given object in the database.
     *
     * @param object - instance of Object class
     * @throws DataAccessException - throws if an error occurs
     */
    void modify(T object) throws DataAccessException;

    /**
     * @param list Lazy Collection to initialize
     */
    void initCollections(List list);

    SessionFactory getSessionFactory();

    void setSessionFactory(SessionFactory sessionFactory);


}
