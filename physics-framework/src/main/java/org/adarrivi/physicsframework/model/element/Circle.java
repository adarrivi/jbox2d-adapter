package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

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
