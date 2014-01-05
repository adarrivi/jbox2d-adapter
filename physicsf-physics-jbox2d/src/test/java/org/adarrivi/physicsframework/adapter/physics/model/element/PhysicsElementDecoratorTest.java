package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.World;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class PhysicsElementDecoratorTest {

    private CircleStub circle = new CircleStub();

    @Mock
    private Body body;
    @Mock
    private World world;
    @InjectMocks
    private PhysicsElementDecorator<CircleStub> victim = new PhysicsDecoratorStub(circle);

    // output
    private Body bodyResult;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(world.createBody(Matchers.any(BodyDef.class))).thenReturn(body);
        Mockito.when(body.createFixture(null)).thenReturn(null);
    }

    // TODO Use powermockito
    @Ignore("Body has some final method implementations.")
    @Test
    public void addToWorld_InvokeWorldCreateBodyDef() {
        whenAddToWorld();
        thenShouldHaveInvokedWorldCreateBodyDef();
    }

    private void whenAddToWorld() {
        bodyResult = victim.addToWorld(world);
    }

    private void thenShouldHaveInvokedWorldCreateBodyDef() {
        Mockito.verify(world).createBody(Matchers.any(BodyDef.class));
    }

    // TODO Use powermockito
    @Ignore("Body has some final method implementations.")
    @Test
    public void addToWorld_DoesntReturnNull() {
        whenAddToWorld();
        thenBodyShouldNotBeNull();
    }

    private void thenBodyShouldNotBeNull() {
        Assert.assertNotNull(bodyResult);
    }

}
