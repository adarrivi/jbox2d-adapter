package org.adarrivi.physicsframework.model.force;

import org.junit.Assert;
import org.junit.Test;

public class ForceFactoryTest {

    private ForceFactory victim = new ForceFactory();

    // output
    private Force resultForce;

    @Test
    public void createLinearForce_DoesntReturnNull() {
        whenCreateLinearForce();
        thenResultForceShouldNotBeNull();
    }

    private void whenCreateLinearForce() {
        resultForce = victim.createLinearForce(0, 0);
    }

    private void thenResultForceShouldNotBeNull() {
        Assert.assertNotNull(resultForce);
    }

    @Test
    public void createAngularForce_DoesntReturnNull() {
        whenCreateAngularForce();
        thenResultForceShouldNotBeNull();
    }

    private void whenCreateAngularForce() {
        resultForce = victim.createAngularForce(0, true);
    }

}
