package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;

class CircleStub extends Circle {

    protected CircleStub() {
        super(new Position(0, 0), DynamicType.DYNAMIC, 0);
    }

}
