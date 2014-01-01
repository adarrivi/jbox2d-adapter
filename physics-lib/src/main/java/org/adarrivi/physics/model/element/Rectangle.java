package org.adarrivi.physics.model.element;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public class Rectangle extends PhysicalElement {

    private float width;
    private float height;

    Rectangle(PhysicsAdapter physicsAdapter, float width, float height) {
        super(physicsAdapter);
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
