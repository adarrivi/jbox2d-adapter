package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SpecialRectangle extends Rectangle {

    private RectangleType type;

    SpecialRectangle(PhysicsAdapter physicsAdapter, DynamicType dynamicType, float width, float height) {
        super(physicsAdapter, dynamicType, width, height);
    }

    public RectangleType getType() {
        return type;
    }

    public void setType(RectangleType type) {
        this.type = type;
    }

}
