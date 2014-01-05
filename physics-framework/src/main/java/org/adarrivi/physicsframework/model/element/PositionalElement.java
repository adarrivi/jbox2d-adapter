package org.adarrivi.physicsframework.model.element;

/**
 * Defines an element with a position and type
 * 
 * @author adarrivi
 * 
 */
public interface PositionalElement {

    Position getPosition();

    void updatePosition(Position position);

    DynamicType getDynamicType();

}
