package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public abstract class Element implements PositionalElement {

    private PhysicsAdapter physicsAdapter;
    private DynamicType dynamicType;

    protected Element(PhysicsAdapter physicsAdapter, DynamicType dynamicType) {
        this.physicsAdapter = physicsAdapter;
        this.dynamicType = dynamicType;
    }

    @Override
    public Position getLatestPosition() {
        return physicsAdapter.getLatestPosition(this);
    }

    @Override
    public DynamicType getDynamicType() {
        return dynamicType;
    }
}
