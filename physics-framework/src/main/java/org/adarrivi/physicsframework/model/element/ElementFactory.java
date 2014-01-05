package org.adarrivi.physicsframework.model.element;

/**
 * Factory for the different elements creation
 * 
 * @author adarrivi
 * 
 */
public class ElementFactory {

    public SandBox createEarthSandBox() {
        return new SandBox(true);
    }

    public Circle createCircle(Position position, float radius, DynamicType type) {
        return new Circle(position, type, radius);
    }

    public Rectangle createRectangle(Position position, float width, float height, DynamicType type) {
        return new Rectangle(position, type, width, height);
    }
}
