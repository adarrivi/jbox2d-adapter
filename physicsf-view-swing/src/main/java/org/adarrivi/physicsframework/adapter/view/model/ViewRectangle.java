package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.List;

import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.Rectangle;

class ViewRectangle extends ViewPositionalElementDecorator<Rectangle> {

    ViewRectangle(Rectangle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        Position latestPosition = getDecoratedElement().getLatestPosition();
        ViewPosition viewPosition = toViewPosition(latestPosition);
        AffineTransform rotator = AffineTransform.getRotateInstance(viewPosition.getRotation(), viewPosition.getX(), viewPosition.getY());
        g2d.setTransform(rotator);
        List<Position> vertexList = getDecoratedElement().getVertexList(latestPosition);
        int vertexCount = vertexList.size();
        int[] intX = new int[vertexCount];
        int[] intY = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ViewPosition vertexPosition = toViewPosition(vertexList.get(i));
            intX[i] = vertexPosition.getX();
            intY[i] = vertexPosition.getY();
        }
        g2d.fillPolygon(intX, intY, vertexCount);
    }
}
