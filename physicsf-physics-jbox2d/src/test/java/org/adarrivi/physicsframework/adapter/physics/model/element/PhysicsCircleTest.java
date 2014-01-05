package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.Circle;
import org.jbox2d.dynamics.FixtureDef;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PhysicsCircleTest {

    @Mock
    private Circle circle;

    @InjectMocks
    private PhysicsCircle victim = new PhysicsCircle(circle);

    // output
    private FixtureDef fixtureDefResult;

    @Test
    public void createFixtureDef_InvokesGetRadius() {
        whenCreateFixtureDef();
        thenShouldHaveInvokedGetRadius();
    }

    private void whenCreateFixtureDef() {
        fixtureDefResult = victim.createFixtureDef();
    }

    private void thenShouldHaveInvokedGetRadius() {
        Mockito.verify(circle).getRadius();
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
