package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.AngularForce;
import org.adarrivi.physicsframework.model.force.Force;
import org.adarrivi.physicsframework.model.force.LinearForce;

public class Jbox2dForceDecoratorFactory {

    public PhysicsForceDecorator<?> createForceDecorator(Force force) {
        if (force instanceof LinearForce) {
            return new PhysicsLinearForce((LinearForce) force);
        }
        if (force instanceof AngularForce) {
            return new PhysicsAngularForce((AngularForce) force);
        }
        return new NullForceDecorator(force);
    }

}
