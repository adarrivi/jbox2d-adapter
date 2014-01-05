package org.adarrivi.physicsframework.model.element;

/**
 * Rectangle entity with width and height
 * 
 * @author adarrivi
 * 
 */
public class Rectangle extends Element {

    private float width;
    private float height;

    public Rectangle(Position position, DynamicType dynamicType, float width, float height) {
        super(position, dynamicType);
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
