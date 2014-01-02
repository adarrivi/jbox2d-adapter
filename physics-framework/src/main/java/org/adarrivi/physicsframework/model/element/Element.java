package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public abstract class Element implements PositionalElement {

    private PhysicsAdapter physicsAdapter;

    protected Element(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    @Override
    public Position getPosition() {
        return physicsAdapter.getLatestPosition(this);
    }
}
