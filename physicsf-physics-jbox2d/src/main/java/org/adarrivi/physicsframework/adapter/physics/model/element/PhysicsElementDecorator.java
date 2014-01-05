package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

public abstract class PhysicsElementDecorator<P extends PositionalElement> implements WorldElement {

    private P decoratedElement;

    protected PhysicsElementDecorator(P decoratedElement) {
        this.decoratedElement = decoratedElement;
    }

    protected P getDecoratedElement() {
        return decoratedElement;
    }

    @Override
    public final Body addToWorld(World world) {
        BodyDef bd = new BodyDef();
        if (DynamicType.DYNAMIC.equals(decoratedElement.getDynamicType())) {
            bd.type = BodyType.DYNAMIC;
        }
        bd.position = toVec2(decoratedElement.getPosition());
        bd.angle = decoratedElement.getPosition().getRotation();
        Body body = world.createBody(bd);
        body.createFixture(createFixtureDef());
        return body;
    }

    private Vec2 toVec2(Position position) {
        return new Vec2(position.getX(), position.getY());
    }

    protected abstract FixtureDef createFixtureDef();

}
