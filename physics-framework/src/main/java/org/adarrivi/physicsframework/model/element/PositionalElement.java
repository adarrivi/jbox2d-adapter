package org.adarrivi.physicsframework.model.element;

public interface PositionalElement {

    Position getPosition();

    void updatePosition(Position position);

    DynamicType getDynamicType();

}
