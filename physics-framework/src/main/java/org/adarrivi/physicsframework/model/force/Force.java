package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public abstract class Force {

    private PhysicsAdapter physicsAdapter;
    private float magnitude;

    protected Force(PhysicsAdapter physicsAdapter, float magnitude) {
        this.physicsAdapter = physicsAdapter;
        this.magnitude = magnitude;
    }

    protected PhysicsAdapter getPhysicsAdapter() {
        return physicsAdapter;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }

    public void applyOn(Element element) {
        getPhysicsAdapter().applyForce(this, element);
    }
}
