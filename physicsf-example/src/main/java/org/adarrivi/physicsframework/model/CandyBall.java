package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class CandyBall extends Circle {

    CandyBall(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter, DynamicType.DYNAMIC, 0.6f);
    }

}
