package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.Force;
import org.jbox2d.dynamics.Body;

public class NullForceDecorator extends PhysicsForceDecorator<Force> {

    NullForceDecorator(Force decoratedForce) {
        super(decoratedForce);
    }

    @Override
    public void applyForce(Body body) {
        // Nothing to do
    }

}
