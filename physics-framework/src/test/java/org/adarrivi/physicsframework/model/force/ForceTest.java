package org.adarrivi.physicsframework.model.force;

import org.junit.Assert;
import org.junit.Test;

public class ForceTest {

    private static final float MAGNITUDE = 5;

    private Force victim = new LinearForce(MAGNITUDE, 0);

    // output
    private float floatResult;

    @Test
    public void getMagnitude_ReturnsValueFromConstructor() {
        whenGetMagnitude();
        thenFloatResultShouldBe(MAGNITUDE);
    }

    private void whenGetMagnitude() {
        floatResult = victim.getMagnitude();
    }

    private void thenFloatResultShouldBe(float expectedValue) {
        Assert.assertEquals(expectedValue, floatResult, 0);
    }

    @Test
    public void getMagnitude_AfterSet_ReturnsSetValue() {
        float newValue = 20;
        whenSetMagnitude(newValue);
        whenGetMagnitude();
        thenFloatResultShouldBe(newValue);
    }

    private void whenSetMagnitude(float value) {
        victim.setMagnitude(value);
    }
}
