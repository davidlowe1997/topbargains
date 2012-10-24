/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.topbargains.service.dao.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.topbargains.model.Bargain;
import org.topbargains.model.Image;
import org.topbargains.model.User;
import org.topbargains.service.dao.CommonDAO;

/**
 *
 * @author Bruno Barin
 */
@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true, transactionManager = "transactionManager")
@Transactional
public class JdoDAOImplIT {

    @Autowired
    private CommonDAO commonDAO;

    @Test
    public void testStore() {
        User user = new User("user@domain.com");
        commonDAO.store(user);
        byte[] content = new byte[] {0,1,0,1,0,1,0,1,0,0,0};
        Image image = new Image((short)300, (short)200, content, Image.ImageType.JPEG);
        Bargain bargain = new Bargain("PS3 for only 100 euros!!!", "Hey guys!\r\n Amazon is selling the new PS3 for only 100 bucks. Incredible huh?", "http://www.amazon.co.uk/ps3deal", user);
        bargain.setExpirationDate(Calendar.getInstance().getTime());
        bargain.setImage(image);
        
        commonDAO.store(bargain);
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testFindById() {
    }
}
