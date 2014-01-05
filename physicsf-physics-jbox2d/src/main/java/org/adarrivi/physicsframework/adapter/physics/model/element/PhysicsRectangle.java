package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.Rectangle;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.dynamics.FixtureDef;

public class PhysicsRectangle extends PhysicsElementDecorator<Rectangle> {

    private static final float FRICTION = 0.6f;
    private static final float DENSITY = 1.0f;

    protected PhysicsRectangle(Rectangle decoratedElement) {
        super(decoratedElement);
    }

    @Override
    protected FixtureDef createFixtureDef() {
        FixtureDef fixtureDef = new FixtureDef();
        PolygonShape boxShape = new PolygonShape();
        boxShape.setAsBox(getDecoratedElement().getWidth() / 2, getDecoratedElement().getHeight() / 2);
        fixtureDef.shape = boxShape;
        fixtureDef.density = DENSITY;
        fixtureDef.friction = FRICTION;
        return fixtureDef;
    }

}
