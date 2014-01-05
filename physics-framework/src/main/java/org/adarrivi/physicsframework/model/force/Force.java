package org.adarrivi.physicsframework.model.force;


public abstract class Force {

    private float magnitude;

    protected Force(float magnitude) {
        this.magnitude = magnitude;
    }

    public float getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(float magnitude) {
        this.magnitude = magnitude;
    }
}
