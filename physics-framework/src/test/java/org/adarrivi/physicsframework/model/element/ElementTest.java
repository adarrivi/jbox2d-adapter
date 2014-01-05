package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ElementTest {

    @Mock
    private PhysicsAdapter physicsAdapter;

    private Element victim;

    // input
    private Position givenPosition;

    // output
    private DynamicType dynamicType;
    private Position position;

    @Test
    public void getDynamicType_ReturnsCreationDynamicType() {
        DynamicType type = DynamicType.DYNAMIC;
        givenElement(type);
        whenGetDynamicType();
        thenDynamicTypeShouldBe(type);
    }

    private void givenElement(DynamicType givenDynamicType) {
        victim = new Circle(physicsAdapter, givenDynamicType, 1);
    }

    private void whenGetDynamicType() {
        dynamicType = victim.getDynamicType();
    }

    private void thenDynamicTypeShouldBe(DynamicType expeDynamicType) {
        Assert.assertEquals(expeDynamicType, dynamicType);
    }

    @Test
    public void getLatestPosition_ReturnsLatestFromAdapter() {
        Position pos = new Position(0, 0);
        givenElement(DynamicType.DYNAMIC);
        givenPositionFromAdapter(pos);
        whenGetLatestPosition();
        thenPositionShouldBe(pos);
    }

    private void givenPositionFromAdapter(Position aPosition) {
        givenPosition = aPosition;
        Mockito.when(physicsAdapter.getLatestPosition(victim)).thenReturn(givenPosition);
    }

    private void whenGetLatestPosition() {
        position = victim.getLatestPosition();
    }

    private void thenPositionShouldBe(Position expectedPosition) {
        Assert.assertEquals(expectedPosition, position);
    }

}
