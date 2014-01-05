package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class CandySquare extends Rectangle {

    CandySquare(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter, DynamicType.DYNAMIC, 1.2f, 1.2f);
    }

}
