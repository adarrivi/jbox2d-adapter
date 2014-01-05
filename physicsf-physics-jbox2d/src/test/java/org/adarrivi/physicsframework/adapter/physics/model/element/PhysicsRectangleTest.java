package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.Rectangle;
import org.jbox2d.dynamics.FixtureDef;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhysicsRectangleTest {

    @Mock
    private Rectangle rectangle;

    @InjectMocks
    private PhysicsRectangle victim = new PhysicsRectangle(rectangle);

    // output
    private FixtureDef fixtureDefResult;

    @Test
    public void createFixtureDef_InvokesGetRadius() {
        whenCreateFixtureDef();
        thenShouldHaveInvokedGetWidthAndHeight();
    }

    private void whenCreateFixtureDef() {
        fixtureDefResult = victim.createFixtureDef();
    }

    private void thenShouldHaveInvokedGetWidthAndHeight() {
        Mockito.verify(rectangle).getWidth();
        Mockito.verify(rectangle).getHeight();
    }

    @Test
    public void createFixtureDef_DoesntReturnNull() {
        whenCreateFixtureDef();
        thenFixtureIsNotNull();
    }

    private void thenFixtureIsNotNull() {
        Assert.assertNotNull(fixtureDefResult);
    }

}
