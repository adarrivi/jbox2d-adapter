package org.adarrivi.physicsframework.adapter.physics.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.FixtureDef;

public class PhysicsCircle extends PhysicsElementDecorator<Circle> {

    private static final float FRICTION = 0.9f;
    private static final float DENSITY = 1.0f;

    protected PhysicsCircle(Circle decoratedElement) {
        super(decoratedElement);
    }

    @Override
    protected Body addFixtureDefinition(Body body) {
        CircleShape circle = new CircleShape();
        circle.m_radius = getDecoratedElement().getRadius();
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = circle;
        fixtureDef.density = DENSITY;
        fixtureDef.friction = FRICTION;
        body.createFixture(fixtureDef);
        return body;
    }

}
