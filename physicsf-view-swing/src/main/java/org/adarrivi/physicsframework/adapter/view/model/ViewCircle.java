package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import org.adarrivi.physicsframework.model.element.Circle;

class ViewCircle extends ViewPositionalElementDecorator<Circle> {

    ViewCircle(Circle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        AffineTransform oldTransform = g2d.getTransform();
        ViewPosition viewPosition = toViewPosition(getDecoratedElement().getPosition());
        AffineTransform rotator = AffineTransform.getRotateInstance(viewPosition.getRotation(), viewPosition.getX(), viewPosition.getY());
        g2d.setTransform(rotator);
        g2d.setColor(Color.BLUE);
        int viewRadius = toViewValue(getDecoratedElement().getRadius());
        Ellipse2D.Double circle = new Ellipse2D.Double(viewPosition.getX() - viewRadius, viewPosition.getY() - viewRadius, 2 * viewRadius,
                2 * viewRadius);
        g2d.fill(circle);
        g2d.setColor(Color.GRAY);
        g2d.drawLine(viewPosition.getX(), viewPosition.getY(), viewPosition.getX() + viewRadius, viewPosition.getY());

        g2d.setTransform(oldTransform);
    }

}
