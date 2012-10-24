package org.topbargains.service.dao.impl;


import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.annotations.Transactional;
import org.topbargains.service.dao.CommonDAO;

/**
 *
 * @author Bruno Barin
 */
class JdoDAOImpl implements CommonDAO {

    private final PersistenceManagerFactory persistenceManagerFactory;

    public JdoDAOImpl(final PersistenceManagerFactory persistenceManagerFactory) {
        this.persistenceManagerFactory = persistenceManagerFactory;
    }

    private PersistenceManager getPersistenceManager() {
        return this.persistenceManagerFactory.getPersistenceManager();
    }

    @Override
    public <T> T store(final T obj) {
        return getPersistenceManager().makePersistent(obj);
    }

    @Override
    public <T> void remove(final T obj) {
        getPersistenceManager().deletePersistent(obj);
    }
    
    @Override
    public <T> T findById(final Class<T> clazz, final Object key) {
        return getPersistenceManager().getObjectById(clazz, key);
    }
}
