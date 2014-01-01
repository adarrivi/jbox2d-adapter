package org.adarrivi.physics.model.element;

import java.util.ArrayList;
import java.util.List;

import org.adarrivi.physics.adapter.PhysicsAdapter;

public class Rectangle extends PhysicalElement {

    private float width;
    private float height;

    Rectangle(PhysicsAdapter physicsAdapter, float width, float height) {
        super(physicsAdapter);
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
