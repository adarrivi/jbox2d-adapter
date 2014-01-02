package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import org.adarrivi.physicsframework.model.element.Circle;

class ViewCircle extends ViewPositionalElementDecorator<Circle> {

    ViewCircle(Circle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        ViewPosition viewPosition = toViewPosition(getDecoratedElement().getPosition());
        int screenRadius = toViewValue(getDecoratedElement().getRadius());
        Ellipse2D.Double circle = new Ellipse2D.Double(viewPosition.getX() - screenRadius, viewPosition.getY() - screenRadius,
                2 * screenRadius, 2 * screenRadius);
        g2d.fill(circle);
    }

}