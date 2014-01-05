package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class CandyBar extends Rectangle {

    CandyBar(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter, DynamicType.STATIC, 8f, 0.72f);
    }

}
