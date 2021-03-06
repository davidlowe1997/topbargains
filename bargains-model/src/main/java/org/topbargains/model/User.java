package org.topbargains.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.Validate;
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
     * User's nickname
     */
    @NotNull
    @Unique
    private String nickname;
    /**
     * The date user registered in the system
     */
    @Persistent
    private Date memberSince;

    /**
     * User's constructor
     *
     * @param email The email identifying the user
     * @param nickname The user's chosen nickname
     */
    public User(String email, String nickname) {
        Validate.notEmpty(email);
        Validate.notEmpty(nickname);

        this.email = email;
        this.nickname = nickname;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
