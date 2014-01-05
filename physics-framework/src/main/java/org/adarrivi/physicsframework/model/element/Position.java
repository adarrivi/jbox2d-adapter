package org.adarrivi.physicsframework.model.element;

/**
 * Defines a position within the physics engine
 * 
 * @author adarrivi
 * 
 */
public class Position {

    private float x;
    private float y;
    private float rotation;

    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getRotation() {
        return rotation;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Position add(Position position) {
        return new Position(x + position.x, y + position.y);
    }

}
