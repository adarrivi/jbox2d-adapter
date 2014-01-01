package org.adarrivi.physics.model.element;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public abstract class PhysicalElement {

    private PhysicsAdapter physicsAdapter;

    protected PhysicalElement(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    public Position getPosition() {
        return physicsAdapter.getLatestPosition(this);
    }
}
