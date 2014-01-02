package org.adarrivi.physicsframework.adapter.view.model;

public class ViewPosition {

    private int x;
    private int y;
    private float rotation;

    public ViewPosition(int x, int y, float rotation) {
        this.x = x;
        this.y = y;
        this.rotation = rotation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getRotation() {
        return rotation;
    }

}
