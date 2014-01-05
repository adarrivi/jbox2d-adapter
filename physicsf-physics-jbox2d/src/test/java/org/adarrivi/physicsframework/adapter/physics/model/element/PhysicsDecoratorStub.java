package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.jbox2d.dynamics.FixtureDef;

public class PhysicsDecoratorStub extends PhysicsElementDecorator<CircleStub> {

    protected PhysicsDecoratorStub(CircleStub decoratedElement) {
        super(decoratedElement);
    }

    @Override
    protected FixtureDef createFixtureDef() {
        return null;
    }

}
