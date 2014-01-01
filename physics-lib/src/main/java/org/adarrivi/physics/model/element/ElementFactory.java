package org.adarrivi.physics.model.element;

import org.adarrivi.physics.adapter.PhysicsAdapter;

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
        Circle circle = new Circle(physicsAdapter, radius);
        physicsAdapter.createElement(circle, position);
        return circle;
    }

    public Rectangle createRectangle(Position position, float width, float height) {
        Rectangle rectangle = new Rectangle(physicsAdapter, width, height);
        physicsAdapter.createElement(rectangle, position);
        return rectangle;
    }

}
