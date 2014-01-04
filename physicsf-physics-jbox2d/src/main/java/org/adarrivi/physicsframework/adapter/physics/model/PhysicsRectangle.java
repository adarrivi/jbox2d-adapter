package org.adarrivi.physicsframework.adapter.physics.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public class PhysicsRectangle extends PhysicsElementDecorator<Rectangle> {

    private static final float FRICTION = 0.9f;
    private static final float DENSITY = 1.0f;

    protected PhysicsRectangle(Rectangle decoratedElement) {
        super(decoratedElement);
    }

    @Override
    public Body addToWorld(World world, Position position) {
        Rectangle decoratedRectangle = getDecoratedElement();

        FixtureDef fd = new FixtureDef();
        PolygonShape sd = new PolygonShape();
        sd.setAsBox(decoratedRectangle.getWidth() / 2, decoratedRectangle.getHeight() / 2);
        fd.shape = sd;
        fd.density = DENSITY;
        fd.friction = FRICTION;

        BodyDef bd = new BodyDef();
        bd.position = toVec2(position);
        bd.angle = position.getRotation();
        if (DynamicType.DYNAMIC.equals(decoratedRectangle.getDynamicType())) {
            bd.type = BodyType.DYNAMIC;
        }
        Body body = world.createBody(bd);
        body.createFixture(fd);
        return body;
    }

}
