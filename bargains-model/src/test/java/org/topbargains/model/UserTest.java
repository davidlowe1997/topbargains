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
    
    @Test
    public void constructorWithNullEmail() {
        new User(null);
    }
    
    @Test
    public void constructorWithEmptyEmail() {
        new User("");
    }

    @Test
    public void creationDateIsToday() {
        Date memberSince = new User("user@domain.com").getMemberSince();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(memberSince);
        assertEquals(0,memberSince.compareTo(new Date()));
    }
}
