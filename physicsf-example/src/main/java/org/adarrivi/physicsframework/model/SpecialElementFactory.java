package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.ElementFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SpecialElementFactory extends ElementFactory {

    public SpecialElementFactory(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter);
    }

    public SpecialRectangle createSquare(Position position) {
        SpecialRectangle specialRectangle = new SpecialRectangle(getPhysicsAdapter(), DynamicType.DYNAMIC, 1.2f, 1.2f);
        specialRectangle.setType(RectangleType.SQUARE);
        getPhysicsAdapter().createElement(specialRectangle, position);
        return specialRectangle;
    }

    public SpecialRectangle createPlatform(Position position) {
        SpecialRectangle specialRectangle = new SpecialRectangle(getPhysicsAdapter(), DynamicType.STATIC, 8f, 0.4f);
        specialRectangle.setType(RectangleType.PLATFORM);
        getPhysicsAdapter().createElement(specialRectangle, position);
        return specialRectangle;
    }

}
