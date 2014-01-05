package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.Force;

public abstract class PhysicsForceDecorator<F extends Force> implements WorldForce {

    private F decoratedForce;

    protected PhysicsForceDecorator(F decoratedForce) {
        this.decoratedForce = decoratedForce;
    }

    protected F getDecoratedForce() {
        return decoratedForce;
    }

}
