/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.topbargains.model;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Bruno Barin
 */
public class UserTest {
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullEmail() {
        new User(null,"bbarin");
    }
    
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullNickname() {
        new User("ddd",null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithEmptyEmail() {
        new User("","bbarin");
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithEmptyNickname() {
        new User("dsdsd","");
    }

    @Test
    public void creationDateIsToday() {
        Date memberSince = new User("user@domain.com","bbarin").getMemberSince();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(memberSince);
        assertEquals(0,memberSince.compareTo(new Date()));
    }
}
