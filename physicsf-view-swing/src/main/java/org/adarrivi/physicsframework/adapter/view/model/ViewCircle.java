package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import org.adarrivi.physicsframework.model.element.Circle;

class ViewCircle extends ViewPositionalElementDecorator<Circle> {

    ViewCircle(Circle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfPosition(Graphics2D g2d, ViewPosition position) {
        g2d.setColor(Color.BLUE);

        int viewRadius = toViewValue(getDecoratedElement().getRadius());
        int viewDiamenter = 2 * viewRadius;
        AffineTransform transform = new AffineTransform();
        transform.rotate(position.getRotation(), position.getX(), position.getY());
        transform.translate(position.getX() - viewRadius, position.getY() - viewRadius);

        Shape circle = new Ellipse2D.Double(0, 0, viewDiamenter, viewDiamenter);
        circle = transform.createTransformedShape(circle);

        Shape rectangleShape = new java.awt.Rectangle(viewRadius, viewRadius);
        AffineTransform transformR = new AffineTransform();
        transformR.rotate(position.getRotation(), position.getX(), position.getY());
        transformR.translate(position.getX() - viewRadius / 2, position.getY() - viewRadius / 2);

        rectangleShape = transformR.createTransformedShape(rectangleShape);
        g2d.draw(circle);
        g2d.setColor(Color.GRAY);
        g2d.draw(rectangleShape);
    }

}
