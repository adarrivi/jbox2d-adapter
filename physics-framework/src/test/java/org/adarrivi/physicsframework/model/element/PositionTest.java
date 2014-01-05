package org.adarrivi.physicsframework.model.element;

import org.junit.Assert;
import org.junit.Test;

public class PositionTest {

    private static final float X_POS = 1;
    private static final float Y_POS = 2;
    private static final float ROTATION = 3;

    private Position victim = new Position(X_POS, Y_POS);

    // output
    private float floatResult;
    private Position positionResult;

    @Test
    public void getRotation_ReturnsRotationSet() {
        givenRotation();
        whenGetRotation();
        thenFloatResultShouldBe(ROTATION);
    }

    private void givenRotation() {
        victim.setRotation(ROTATION);
    }

    private void whenGetRotation() {
        floatResult = victim.getRotation();
    }

    private void thenFloatResultShouldBe(float expectedValue) {
        Assert.assertEquals(expectedValue, floatResult, 0);
    }

    @Test
    public void getX_ReturnsXValue() {
        givenRotation();
        whenGetX();
        thenFloatResultShouldBe(X_POS);
    }

    private void whenGetX() {
        floatResult = victim.getX();
    }

    @Test
    public void getY_ReturnsYValue() {
        givenRotation();
        whenGetY();
        thenFloatResultShouldBe(Y_POS);
    }

    private void whenGetY() {
        floatResult = victim.getY();
    }

    @Test
    public void add_Self_DoublesXandY() {
        whenAddSelf();
        thenPositionResultShouldBeDouble();
    }

    private void whenAddSelf() {
        positionResult = victim.add(victim);
    }

    private void thenPositionResultShouldBeDouble() {
        Assert.assertEquals(victim.getX() * 2, positionResult.getX(), 0);
        Assert.assertEquals(victim.getY() * 2, positionResult.getY(), 0);
    }

    @Test
    public void add_Self_DoesNotModifySelf() {
        whenAddSelf();
        thenSelftRemainsSame();
    }

    private void thenSelftRemainsSame() {
        Assert.assertEquals(X_POS, victim.getX(), 0);
        Assert.assertEquals(Y_POS, victim.getY(), 0);
    }
}
