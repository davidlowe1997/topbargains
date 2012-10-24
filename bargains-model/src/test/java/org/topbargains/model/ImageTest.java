package org.topbargains.model;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;

/**
 *
 * @author Bruno Barin
 */
public class ImageTest {
       
    private byte[] content = new byte[]{};
    
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithInvalidWidth() {
        new Image((short)-15, (short)0, content, Image.ImageType.JPEG);
    }
    @Test(expected=IllegalArgumentException.class)
    public void constructorWithInvalidHeight() {
        new Image((short)0, (short)-100, content, Image.ImageType.JPEG);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullContent() {
        new Image((short)-40, (short)-100, null, Image.ImageType.JPEG);
    }

    @Test(expected=IllegalArgumentException.class)
    public void constructorWithNullImageType() {
        new Image((short)-40, (short)-100, content, null);
    }
}
