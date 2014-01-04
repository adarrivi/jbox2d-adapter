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

    public Circle createCircle(Position position, float radius, DynamicType type) {
        Circle circle = new Circle(physicsAdapter, type, radius);
        physicsAdapter.createElement(circle, position);
        return circle;
    }

    public Rectangle createRectangle(Position position, float width, float height, DynamicType type) {
        Rectangle rectangle = new Rectangle(physicsAdapter, type, width, height);
        physicsAdapter.createElement(rectangle, position);
        return rectangle;
    }

    protected PhysicsAdapter getPhysicsAdapter() {
        return physicsAdapter;
    }

}
