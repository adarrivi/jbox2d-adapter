package org.adarrivi.physicsframework.model.element;

import java.util.ArrayList;
import java.util.List;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class Rectangle extends Element {

    private float width;
    private float height;

    Rectangle(PhysicsAdapter physicsAdapter, DynamicType dynamicType, float width, float height) {
        super(physicsAdapter, dynamicType);
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public List<Position> getVertexList() {
        Position centerPosition = getPosition();
        List<Position> vertexList = new ArrayList<>();
        float halfWidth = width / 2;
        float halfHeight = height / 2;
        vertexList.add(new Position(centerPosition.getX() - halfWidth, centerPosition.getY() + halfHeight));
        vertexList.add(new Position(centerPosition.getX() + halfWidth, centerPosition.getY() + halfHeight));
        vertexList.add(new Position(centerPosition.getX() + halfWidth, centerPosition.getY() - halfHeight));
        vertexList.add(new Position(centerPosition.getX() - halfWidth, centerPosition.getY() - halfHeight));
        return vertexList;
    }
}
