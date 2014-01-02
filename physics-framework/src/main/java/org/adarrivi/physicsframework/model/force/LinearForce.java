package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class LinearForce extends Force {

    private float magnitude;
    private float direction;

    LinearForce(PhysicsAdapter physicsAdapter, float magnitude, float direction) {
        super(physicsAdapter);
        this.magnitude = magnitude;
        this.direction = direction;
    }

    public float getMagnitud() {
        return magnitude;
    }

    public void setMagnitud(float magnitud) {
        this.magnitude = magnitud;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }

    public <E extends Element> void applyOn(E element) {
        getPhysicsAdapter().applyForce(this, element);
    }

}
