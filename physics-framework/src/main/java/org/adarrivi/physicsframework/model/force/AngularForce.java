package org.adarrivi.physicsframework.model.force;


public class AngularForce extends Force {

    private boolean clockwise;

    AngularForce(float magnitude, boolean clockwise) {
        super(magnitude);
        this.clockwise = clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }
}
