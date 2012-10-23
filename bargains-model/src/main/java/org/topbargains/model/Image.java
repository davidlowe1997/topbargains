package org.topbargains.model;

import javax.jdo.annotations.PersistenceCapable;
import org.apache.commons.lang.Validate;

/**
 * Represents an image of a bargain
 * @author Bruno Barin
 */
@PersistenceCapable
public class Image {

    /** The image width */
    private short width;
    /** The image height */
    private short height;
    /** The image content */
    private byte[] content;
    /** The image type */
    private ImageType type;

    /**
     * Image's constructor
     * @param width The image width
     * @param height The image height
     * @param content The binary content
     * @param type The image type (jpg,bmp,gif,png)
     */
    public Image(final short width, final short height, final byte[] content, final ImageType type) {
        Validate.isTrue(width >= 0, "Invalid image width (negative)");
        Validate.isTrue(height >= 0, "Invalid image height (negative)");
        Validate.notNull(content);
        Validate.notNull(type);
        
        this.width = width;
        this.height = height;
        this.content = content;
        this.type = type;
    }

    public short getWidth() {
        return width;
    }

    public short getHeight() {
        return height;
    }

    public byte[] getContent() {
        return content.clone();
    }

    public ImageType getType() {
        return type;
    }
    
    /**
     * The image type enumeration
     */    
    static enum ImageType {
        JPEG("image/jpeg"),
        GIF("image/gif"),
        PNG("image/png"),
        BMP("image/bmp");
        
        private String mimeType;
        
        private ImageType(String mimeType) {
            this.mimeType = mimeType;
        }
        
        public final String getMimeType() {
            return this.mimeType;
        }
    }
}
