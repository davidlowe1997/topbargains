/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.topbargains.service.dao;

/**
 *
 * @author Bruno Barin
 */
public interface CommonDAO {

    <T> T findById(final Class<T> clazz, final Object key);

    <T> void remove(final T obj);

    <T> T store(final T obj);
    
}
