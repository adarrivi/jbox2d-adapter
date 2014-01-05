package org.adarrivi.physicsframework.model.force;

import org.junit.Assert;
import org.junit.Test;

public class LinearForceTest {

    private static final float DIRECTION_ANGLE = 1;

    private LinearForce victim = new LinearForce(1, DIRECTION_ANGLE);

    // output
    private float floatResult;

    @Test
    public void getDirectionAngle_ReturnsValueFromConstructor() {
        whenGetDirectionAngle();
        thenFloatResultShouldBe(DIRECTION_ANGLE);
    }

    private void whenGetDirectionAngle() {
        floatResult = victim.getDirectionAngle();
    }

    private void thenFloatResultShouldBe(float expectedValue) {
        Assert.assertEquals(expectedValue, floatResult, 0);
    }

    private void whenSetDirectionAngle(float value) {
        victim.setDirectionAngle(value);
    }

    @Test
    public void getDirectionAngle_AfterSet_ReturnsSetValue() {
        float newValue = 10;
        whenSetDirectionAngle(newValue);
        whenGetDirectionAngle();
        thenFloatResultShouldBe(newValue);
    }

}
