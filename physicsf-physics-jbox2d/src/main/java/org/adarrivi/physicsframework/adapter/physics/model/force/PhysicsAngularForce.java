package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.AngularForce;
import org.jbox2d.dynamics.Body;

public class PhysicsAngularForce extends PhysicsForceDecorator<AngularForce> {

    PhysicsAngularForce(AngularForce decoratedForce) {
        super(decoratedForce);
    }

    @Override
    public void applyForce(Body body) {
        float torque = getDecoratedForce().isClockwise() ? -getDecoratedForce().getMagnitude() : getDecoratedForce().getMagnitude();
        body.applyTorque(torque);
    }

}
