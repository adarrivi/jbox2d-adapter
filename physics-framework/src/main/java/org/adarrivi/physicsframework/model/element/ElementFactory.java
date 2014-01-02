package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class ElementFactory {

    private PhysicsAdapter physicsAdapter;

    public SandBox createEarthSandBox() {
        SandBox sandBox = new SandBox(physicsAdapter, true);
        physicsAdapter.createSandBox(sandBox);
        return sandBox;
    }

    public ElementFactory(PhysicsAdapter physicsAdapter) {
        this.physicsAdapter = physicsAdapter;
    }

    public Circle createCircle(Position position, float radius) {
        return createCircleWithType(position, DynamicType.DYNAMIC, radius);
    }

    private Circle createCircleWithType(Position position, DynamicType type, float radius) {
        Circle circle = new Circle(physicsAdapter, type, radius);
        physicsAdapter.createElement(circle, position);
        return circle;
    }

    public Circle createStaticCircle(Position position, float radius) {
        return createCircleWithType(position, DynamicType.STATIC, radius);
    }

    public Rectangle createRectangle(Position position, float width, float height) {
        return createRectangleWithType(position, DynamicType.DYNAMIC, width, height);
    }

    private Rectangle createRectangleWithType(Position position, DynamicType type, float width, float height) {
        Rectangle rectangle = new Rectangle(physicsAdapter, type, width, height);
        physicsAdapter.createElement(rectangle, position);
        return rectangle;
    }

    public Rectangle createStaticRectangle(Position position, float width, float height) {
        return createRectangleWithType(position, DynamicType.STATIC, width, height);
    }

}
