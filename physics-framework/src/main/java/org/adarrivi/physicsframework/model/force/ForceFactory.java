package org.adarrivi.physicsframework.model.force;

/**
 * Factory to create the different forces
 * 
 * @author adarrivi
 * 
 */
public class ForceFactory {

    public LinearForce createLinearForce(float magnitude, float direction) {
        return new LinearForce(magnitude, direction);
    }

    public AngularForce createAngularForce(float magnitude, boolean clockwise) {
        return new AngularForce(magnitude, clockwise);
    }

}
