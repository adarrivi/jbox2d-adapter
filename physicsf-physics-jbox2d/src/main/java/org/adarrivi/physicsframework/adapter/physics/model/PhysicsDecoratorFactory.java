package org.adarrivi.physicsframework.adapter.physics.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

public class PhysicsDecoratorFactory {

    private static final float EARTH_GRAVITY = -10f;

    public <P extends PositionalElement> PhysicsElementDecorator<?> decoratePositionalElement(P element) {
        if (element instanceof Circle) {
            return new PhysicsCircle((Circle) element);
        }
        if (element instanceof Rectangle) {
            return new PhysicsRectangle((Rectangle) element);
        }
        return null;
    }

    public World createWorld(boolean hasEarthGravity) {
        Vec2 gravityVector = new Vec2(0f, 0f);
        if (hasEarthGravity) {
            gravityVector.y = EARTH_GRAVITY;
        }
        World world = new World(gravityVector);
        world.setContinuousPhysics(true);
        return world;
    }
}
