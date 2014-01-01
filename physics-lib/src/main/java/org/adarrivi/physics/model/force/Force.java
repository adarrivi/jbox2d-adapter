package org.adarrivi.physics.model.force;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public abstract class Force {

    private PhysicsAdapter physicsAdapter;

    protected Force(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    protected PhysicsAdapter getPhysicsAdapter() {
        return physicsAdapter;
    }

}
