package org.topbargains.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

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

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
