package org.adarrivi.physicsframework.model.force;

/**
 * Linear force to be applied to entities
 * 
 * @author adarrivi
 * 
 */
public class LinearForce extends Force {

    private float directionAngle;

    LinearForce(float magnitude, float directionAngle) {
        super(magnitude);
        this.directionAngle = directionAngle;
    }

    public float getDirectionAngle() {
        return directionAngle;
    }

    public void setDirectionAngle(float direction) {
        this.directionAngle = direction;
    }

}
