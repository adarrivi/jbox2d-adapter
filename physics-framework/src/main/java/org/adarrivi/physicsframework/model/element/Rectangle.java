package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class Rectangle extends Element {

    private float width;
    private float height;

    public Rectangle(PhysicsAdapter physicsAdapter, DynamicType dynamicType, float width, float height) {
        super(physicsAdapter, dynamicType);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}
