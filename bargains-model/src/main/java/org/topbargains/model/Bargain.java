/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.topbargains.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.validation.constraints.NotNull;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Represents a bargain in the system.
 *
 * @author Bruno Barin
 */
@PersistenceCapable
public class Bargain implements Serializable {

    /**
     * The bargain identifier
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
    private Long id;
    /**
     * The title
     */
    @NotNull
    @Persistent
    private String title;
    /**
     * The description
     */
    @NotNull
    @Persistent
    private String description;
    /**
     * The publish date
     */
    @Persistent
    private Date publishDate;
    /**
     * The URL to the bargain
     */
    @NotNull
    @Persistent
    private String url;
    /**
     * The bargain's image
     */
    @Persistent
    private Image image;
    /**
     * How hot the bargain is
     */
    @Persistent
    private Integer hotness = 0;
    /**
     * How cold the bargain is
     */
    @Persistent
    private Integer coldness = 0;
    /**
     * The user who posted the bargain
     */
    @NotNull
    @Persistent
    private User addedBy;
    /**
     * The expiration date
     */
    @Persistent
    private Date expirationDate;

    /**
     * Bargain constructor
     *
     * @param title The title
     * @param description The description
     * @param url The URL to the bargain
     */
    public Bargain(String title, String description, String url, User addedBy) {
        Validate.notEmpty(title);
        Validate.notEmpty(description);
        Validate.notEmpty(url);
        Validate.notNull(addedBy);

        this.title = title;
        this.description = description;
        this.url = url;
        this.addedBy = addedBy;
        this.publishDate = Calendar.getInstance().getTime();
        voteHot();
    }

    /**
     * Bargain constructor
     *
     * @param title The title
     * @param description The description
     * @param url The URL to the bargain
     * @param image The bargain's image
     */
    public Bargain(String title, String description, String url, User addedBy, Image image) {
        this(title, description, url, addedBy);
        Validate.notNull(image);
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getHotness() {
        return hotness;
    }

    public final void voteHot() {
        this.hotness += 1;
    }

    public Integer getColdness() {
        return coldness;
    }

    public void voteCold() {
        this.coldness -= 1;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getAddedBy() {
        return addedBy;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Calculates the bargain's rating.
     *
     * @return The bargain's rating.
     */
    public Integer rating() {
        return this.hotness - this.coldness;
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
       return  EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
        
}
