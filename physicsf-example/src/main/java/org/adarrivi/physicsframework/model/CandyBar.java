package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.Rectangle;

public class CandyBar extends Rectangle {

    CandyBar(Position position) {
        super(position, DynamicType.STATIC, 8, 0.72f);
    }

}
