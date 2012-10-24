/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.topbargains.service.dao.impl;

import javax.jdo.PersistenceManagerFactory;
import org.datanucleus.api.jdo.JDOPersistenceManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jdo.JdoTransactionManager;
import org.springframework.orm.jdo.TransactionAwarePersistenceManagerFactoryProxy;
import org.topbargains.service.dao.CommonDAO;


/**
 *
 * @author Bruno Barin
 */
@Configuration
@PropertySource("db-config.properties")
public class TestConfiguration {
    
    @Autowired
    Environment env;
    
    @Bean
    public PersistenceManagerFactory persistenceManagerFactory() {
        final JDOPersistenceManagerFactory jdoPersistenceManagerFactory = new JDOPersistenceManagerFactory();
        jdoPersistenceManagerFactory.setConnectionURL(env.getProperty("db.url"));
        return jdoPersistenceManagerFactory;
    }
    
    @Bean
    public TransactionAwarePersistenceManagerFactoryProxy jdoPersistenceFactoryTargetProxy(){
        final TransactionAwarePersistenceManagerFactoryProxy transactionAwarePersistenceManagerFactoryProxy = new TransactionAwarePersistenceManagerFactoryProxy();
        transactionAwarePersistenceManagerFactoryProxy.setAllowCreate(false);
        transactionAwarePersistenceManagerFactoryProxy.setTargetPersistenceManagerFactory(persistenceManagerFactory());
        return transactionAwarePersistenceManagerFactoryProxy;
    }
    
    @Bean
    public JdoTransactionManager transactionManager() {
        JdoTransactionManager jdoTransactionManager = new JdoTransactionManager();
        jdoTransactionManager.setPersistenceManagerFactory(persistenceManagerFactory());
        return jdoTransactionManager;
    }
    
    @Bean
    public CommonDAO commonDAO() {
        CommonDAO commonDAO = new JdoDAOImpl(jdoPersistenceFactoryTargetProxy().getObject());
        return commonDAO;
    }

}
