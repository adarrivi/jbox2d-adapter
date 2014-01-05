package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

/**
 * Represents a circle
 * 
 * @author adarrivi
 * 
 */
public class Circle extends Element {

    private float radius;

    protected Circle(PhysicsAdapter physicsAdapter, DynamicType dynamicType, float radius) {
        super(physicsAdapter, dynamicType);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

}
