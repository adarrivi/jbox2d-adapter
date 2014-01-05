package org.adarrivi.physicsframework.model.element;


/**
 * Represents a circle
 * 
 * @author adarrivi
 * 
 */
public class Circle extends Element {

    private float radius;

    protected Circle(Position position, DynamicType dynamicType, float radius) {
        super(position, dynamicType);
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

}
