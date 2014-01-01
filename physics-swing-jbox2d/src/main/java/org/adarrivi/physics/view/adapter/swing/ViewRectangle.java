package org.adarrivi.physics.view.adapter.swing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.Rectangle;
import org.adarrivi.physics.view.ViewPosition;

class ViewRectangle extends ViewPositionalElementDecorator<Rectangle> {

    ViewRectangle(Rectangle rectangle, WorldViewConverter worldViewConverter) {
        super(rectangle, worldViewConverter);
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        g2d.setColor(Color.GREEN);
        List<Position> vertexList = getDecoratedElement().getVertexList();
        int vertexCount = vertexList.size();
        int[] intX = new int[vertexCount];
        int[] intY = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ViewPosition vertexPosition = getWorldViewConverter().toScreenPosition(vertexList.get(i));
            intX[i] = vertexPosition.getX();
            intY[i] = vertexPosition.getY();
        }
        g2d.fillPolygon(intX, intY, vertexCount);
    }

}
