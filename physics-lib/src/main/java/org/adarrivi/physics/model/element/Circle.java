package org.adarrivi.physics.model.element;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public class Circle extends PhysicalElement {

    private float radius;

    Circle(PhysicsAdapter physicsAdapter, float radius) {
        super(physicsAdapter);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

}
