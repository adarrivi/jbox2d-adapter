package org.adarrivi.physics.model.element;

import org.adarrivi.physics.physic.adapter.PhysicsAdapter;

public class SandBox {

    private PhysicsAdapter physicsAdapter;
    private boolean earthGravity;

    SandBox(PhysicsAdapter physicsAdapter, boolean earthGravity) {
        this.physicsAdapter = physicsAdapter;
        this.earthGravity = earthGravity;
    }

    public boolean hasEarthGravity() {
        return earthGravity;
    }

    public void step() {
        physicsAdapter.step(this);
    }

}
