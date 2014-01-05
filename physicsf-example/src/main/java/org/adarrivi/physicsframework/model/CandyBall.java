package org.adarrivi.physicsframework.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Position;

public class CandyBall extends Circle {

    CandyBall(Position position) {
        super(position, DynamicType.DYNAMIC, 0.6f);
    }

}
