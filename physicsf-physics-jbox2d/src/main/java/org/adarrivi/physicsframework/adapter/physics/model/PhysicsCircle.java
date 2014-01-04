package org.adarrivi.physicsframework.adapter.physics.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PhysicsCircle extends PhysicsElementDecorator<Circle> {

    private static final float FRICTION = 0.9f;
    private static final float DENSITY = 1.0f;

    protected PhysicsCircle(Circle decoratedElement) {
        super(decoratedElement);
    }

    @Override
    public Body addToWorld(World world, Position position) {
        Circle decoratedCircle = getDecoratedElement();
        CircleShape circle = new CircleShape();
        circle.m_radius = decoratedCircle.getRadius();

        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = DENSITY;
        fd.friction = FRICTION;

        BodyDef bd = new BodyDef();
        if (DynamicType.DYNAMIC.equals(decoratedCircle.getDynamicType())) {
            bd.type = BodyType.DYNAMIC;
        }
        bd.position = toVec2(position);
        bd.angle = position.getRotation();
        Body body = world.createBody(bd);
        body.createFixture(fd);
        return body;
    }

}
