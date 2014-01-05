package org.adarrivi.physicsframework.model.element;

public abstract class Element implements PositionalElement {

    private DynamicType dynamicType;
    private Position position;

    protected Element(Position position, DynamicType dynamicType) {
        this.dynamicType = dynamicType;
        updatePosition(position);
    }

    @Override
    public final void updatePosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public DynamicType getDynamicType() {
        return dynamicType;
    }
}
