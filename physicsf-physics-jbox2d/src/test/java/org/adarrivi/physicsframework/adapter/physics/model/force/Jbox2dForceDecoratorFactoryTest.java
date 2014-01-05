package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.Force;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.junit.Assert;
import org.junit.Test;

public class Jbox2dForceDecoratorFactoryTest {

    private ForceFactory forceFactory = new ForceFactory();
    private Jbox2dForceDecoratorFactory victim = new Jbox2dForceDecoratorFactory();

    // input parameters
    private Force force;

    // output parameters
    private PhysicsForceDecorator<?> forceDecoratorResult;

    @Test
    public void createForceDecorator_LinearForce_DoesntReturnNullForceDecorator() {
        givenForce(forceFactory.createLinearForce(0, 0));
        whenCreateForceDecorator();
        thenForceDecoratorResultShouldNotBeNullForce();
    }

    private void givenForce(Force force) {
        this.force = force;
    }

    private void whenCreateForceDecorator() {
        forceDecoratorResult = victim.createForceDecorator(force);
    }

    private void thenForceDecoratorResultShouldNotBeNullForce() {
        Assert.assertNotNull(forceDecoratorResult);
        Assert.assertFalse(forceDecoratorResult instanceof NullForceDecorator);
    }

    @Test
    public void createForceDecorator_AngularForce_DoesntReturnNullForceDecorator() {
        givenForce(forceFactory.createAngularForce(0, true));
        whenCreateForceDecorator();
        thenForceDecoratorResultShouldNotBeNullForce();
    }

    @Test
    public void createForceDecorator_UnknownForce_ReturnNullForceDecorator() {
        givenForce(new UnknownForce());
        whenCreateForceDecorator();
        thenForceDecoratorResultShouldBeNullForce();
    }

    private void thenForceDecoratorResultShouldBeNullForce() {
        Assert.assertNotNull(forceDecoratorResult);
        Assert.assertTrue(forceDecoratorResult instanceof NullForceDecorator);
    }

}
