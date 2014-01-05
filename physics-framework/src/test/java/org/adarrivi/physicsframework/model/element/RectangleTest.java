package org.adarrivi.physicsframework.model.element;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTest {

    private static final float WIDTH = 1;
    private static final float HEIGHT = 2;

    private Rectangle victim = new Rectangle(null, DynamicType.DYNAMIC, WIDTH, HEIGHT);

    // output
    private float floatResult;

    @Test
    public void getWidth_ReturnsWidthFromConstructor() {
        whenGetWidth();
        thenFloatResultShouldBe(WIDTH);
    }

    private void whenGetWidth() {
        floatResult = victim.getWidth();
    }

    private void thenFloatResultShouldBe(float expectedValue) {
        Assert.assertEquals(expectedValue, floatResult, 0);
    }

    @Test
    public void getHeight_ReturnsHeightFromConstructor() {
        whenGetHeight();
        thenFloatResultShouldBe(HEIGHT);
    }

    private void whenGetHeight() {
        floatResult = victim.getHeight();
    }

}
