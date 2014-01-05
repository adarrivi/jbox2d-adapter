package org.adarrivi.physicsframework.model.element;

import org.junit.Assert;
import org.junit.Test;

public class ElementTest {

    private static final Position POSITION = new Position(0, 0);
    private static final DynamicType TYPE = DynamicType.DYNAMIC;

    private Element victim = new Circle(POSITION, TYPE, 0);

    // output
    private DynamicType dynamicTypeResult;
    private Position positionResult;

    @Test
    public void getDynamicType_ReturnsCreationDynamicType() {
        whenGetDynamicType();
        thenDynamicTypeShouldBe(TYPE);
    }

    private void whenGetDynamicType() {
        dynamicTypeResult = victim.getDynamicType();
    }

    private void thenDynamicTypeShouldBe(DynamicType expeDynamicType) {
        Assert.assertEquals(expeDynamicType, dynamicTypeResult);
    }

    @Test
    public void getPosition_ReturnsPositionFromConstructor() {
        whenGetPosition();
        thenPositionShouldBe(POSITION);
    }

    private void whenGetPosition() {
        positionResult = victim.getPosition();
    }

    private void thenPositionShouldBe(Position expectedPosition) {
        Assert.assertEquals(expectedPosition, positionResult);
    }

}
