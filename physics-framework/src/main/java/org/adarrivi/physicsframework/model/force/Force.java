package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public abstract class Force {

    private PhysicsAdapter physicsAdapter;

    protected Force(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    protected PhysicsAdapter getPhysicsAdapter() {
        return physicsAdapter;
    }

}
