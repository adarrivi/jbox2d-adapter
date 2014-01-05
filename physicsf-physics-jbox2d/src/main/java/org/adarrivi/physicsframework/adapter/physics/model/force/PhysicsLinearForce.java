package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.adarrivi.physicsframework.model.force.LinearForce;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class PhysicsLinearForce extends PhysicsForceDecorator<LinearForce> {

    PhysicsLinearForce(LinearForce decoratedForce) {
        super(decoratedForce);
    }

    @Override
    public void applyForce(Body body) {
        Double xVector = getDecoratedForce().getMagnitude() * Math.cos(getDecoratedForce().getDirectionAngle());
        Double yVector = getDecoratedForce().getMagnitude() * Math.sin(getDecoratedForce().getDirectionAngle());
        Vec2 forceVector = new Vec2(xVector.floatValue(), yVector.floatValue());
        body.applyForceToCenter(forceVector);
    }

}
