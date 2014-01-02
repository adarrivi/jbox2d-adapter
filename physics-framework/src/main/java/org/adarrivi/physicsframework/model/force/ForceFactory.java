package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class ForceFactory {

    private PhysicsAdapter physicsAdapter;

    public ForceFactory(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    public LinearForce createLinearForce(float magnitude, float direction) {
        LinearForce linearForce = new LinearForce(physicsAdapter, magnitude, direction);
        return linearForce;
    }

}
