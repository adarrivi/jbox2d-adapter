package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class LinearForce extends Force {

    private float directionAngle;

    LinearForce(PhysicsAdapter physicsAdapter, float magnitude, float directionAngle) {
        super(physicsAdapter, magnitude);
        this.directionAngle = directionAngle;
    }

    public float getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(float direction) {
        this.directionAngle = direction;
    }

}
