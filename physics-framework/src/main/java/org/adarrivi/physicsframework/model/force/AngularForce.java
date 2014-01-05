package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class AngularForce extends Force {

    private boolean clockwise;

    AngularForce(PhysicsAdapter physicsAdapter, float magnitude, boolean clockwise) {
        super(physicsAdapter, magnitude);
        this.clockwise = clockwise;
    }

    public boolean isClockwise() {
        return clockwise;
    }

    public void setClockwise(boolean clockwise) {
        this.clockwise = clockwise;
    }
}
