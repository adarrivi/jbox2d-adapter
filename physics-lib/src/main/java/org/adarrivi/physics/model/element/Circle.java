package org.adarrivi.physics.model.element;

import org.adarrivi.physics.physic.adapter.PhysicsAdapter;

public class Circle extends Element {

    private float radius;

    Circle(PhysicsAdapter physicsAdapter, float radius) {
        super(physicsAdapter);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

}
