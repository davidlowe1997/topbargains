package org.topbargains.model;

import org.junit.Test;

/**
 *
 * @author Bruno Barin
 */
public class ImageTest {
       
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithInvalidWidth() {
        new Image((short)-15, (short)0, new byte[] {}, Image.ImageType.JPEG);
    }
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithInvalidHeight() {
        new Image((short)0, (short)-100, new byte[] {}, Image.ImageType.JPEG);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullContent() {
        new Image((short)-40, (short)-100, null, Image.ImageType.JPEG);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullImageType() {
        new Image((short)-40, (short)-100, new byte[] {}, null);
    }
}
