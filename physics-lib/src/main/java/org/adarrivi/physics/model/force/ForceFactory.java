package org.adarrivi.physics.model.force;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public class ForceFactory {

    private PhysicsAdapter physicsAdapter;

    public ForceFactory(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    public LinearForce createLinearForce(float magnitude, float direction) {
        LinearForce linearForce = new LinearForce(physicsAdapter, magnitude, direction);
        return linearForce;
    }

    public SpecialForce createSpecialForce() {
        SpecialForce specialForce = new SpecialForce(physicsAdapter);
        return specialForce;
    }

}
