package org.adarrivi.physicsframework.model.force;

import org.junit.Assert;
import org.junit.Test;

public class AngularForceTest {

    private static final boolean CLOCK_WISE = true;

    private AngularForce victim = new AngularForce(0, CLOCK_WISE);

    // output
    private boolean booleanValue;

    @Test
    public void isClockwise_ReturnsValueFromConstructor() {
        whenIsClockwise();
        thenBooleanValueShouldBe(CLOCK_WISE);
    }

    private void whenIsClockwise() {
        booleanValue = victim.isClockwise();
    }

    private void thenBooleanValueShouldBe(boolean expectedValue) {
        Assert.assertEquals(expectedValue, booleanValue);
    }

    @Test
    public void isClockwise_AfterSet_ReturnsSetValue() {
        whenSetClockwise(false);
        thenBooleanValueShouldBe(false);
    }

    private void whenSetClockwise(boolean value) {
        victim.setClockwise(value);

    }

}
