package org.topbargains.model;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Bruno Barin
 */
public class BargainTest {

    private static Validator validator;
    private Bargain bargain;
    final User user = new User("user@domain.com");

    @BeforeClass
    public static void setUpClass() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }
    
    @Before
    public void setUp() {
        this.bargain = new Bargain("The title", "The description", "http://topbargains.org", user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullTitle() {
        new Bargain(null, "bargain description", "http://topbargains.org", user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithEmptyTitle() {
        new Bargain("", "bargain description", "http://topbargains.org", user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullDescription() {
        new Bargain("title", null, "http://topbargains.org", user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithEmptyDescription() {
        new Bargain("title", "", "http://topbargains.org", user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullUrl() {
        new Bargain("title", "", null, user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithEmptyUrl() {
        new Bargain("title", "", null, user);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithInvalidUser() {
        new Bargain("title", "", "http://topbargains.org", null);
    }
    
    public void rateIsOneAfterCreation() {
        assertEquals(Integer.valueOf(1),bargain.rating());
    }
    
    public void rateIsTwoAfterTopUp() {
        bargain.voteHot();
        assertEquals(Integer.valueOf(2),bargain.rating());
    }
    
    public void rateIsZeroAfterTopDown() {
        bargain.voteCold();
        assertEquals(Integer.valueOf(0),bargain.rating());
    }
 }
