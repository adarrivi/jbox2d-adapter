package org.adarrivi.physicsframework.model.element;

import org.junit.Assert;
import org.junit.Test;

public class CircleTest {

    private Circle victim;

    // output parameters
    private float floatResult;

    @Test
    public void getRadius_ReturnsGivenRadius() {
        givenCircleWithRadius(1);
        whenGetRadius();
        thenFloatResultShouldBe(1);
    }

    private void givenCircleWithRadius(float radius) {
        victim = new Circle(null, DynamicType.DYNAMIC, radius);
    }

    private void whenGetRadius() {
        floatResult = victim.getRadius();
    }

    private void thenFloatResultShouldBe(float expectedResult) {
        Assert.assertEquals(expectedResult, floatResult, 0);
    }

}
