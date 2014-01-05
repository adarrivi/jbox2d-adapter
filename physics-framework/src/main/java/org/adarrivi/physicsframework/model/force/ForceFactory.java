package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class ForceFactory {

    private PhysicsAdapter physicsAdapter;

    public ForceFactory(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    public LinearForce createLinearForce(float magnitude, float direction) {
        return new LinearForce(physicsAdapter, magnitude, direction);
    }

    public AngularForce createAngularForce(float magnitude, boolean clockwise) {
        return new AngularForce(physicsAdapter, magnitude, clockwise);
    }

}
