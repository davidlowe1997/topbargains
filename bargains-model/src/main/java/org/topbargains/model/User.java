package org.topbargains.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.NotNull;

/**
 * Represents an user registered in the system
 *
 * @author Bruno Barin
 */
@PersistenceCapable
public class User implements Serializable {

    /**
     * User's email
     */
    @PrimaryKey
    @NotNull
    @Persistent
    private String email;
    /**
     * The date user registered in the system
     */
    @Persistent
    private Date memberSince;

    /**
     * User's constructor
     *
     * @param email The email identifying the user
     */
    public User(String email) {
        this.email = email;
        this.memberSince = Calendar.getInstance().getTime();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getMemberSince() {
        return memberSince;
    }
}
