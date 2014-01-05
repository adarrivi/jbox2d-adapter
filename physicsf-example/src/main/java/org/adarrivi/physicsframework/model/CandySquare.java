package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.Rectangle;

public class CandySquare extends Rectangle {

    CandySquare(Position position) {
        super(position, DynamicType.DYNAMIC, 1.2f, 1.2f);
    }

}
