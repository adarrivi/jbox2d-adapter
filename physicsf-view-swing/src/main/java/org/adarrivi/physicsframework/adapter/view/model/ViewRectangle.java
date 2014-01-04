package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import org.adarrivi.physicsframework.model.element.Rectangle;

class ViewRectangle extends ViewPositionalElementDecorator<Rectangle> {

    ViewRectangle(Rectangle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfPosition(Graphics2D g2d, ViewPosition position) {
        g2d.setColor(Color.GREEN);

        int width = toViewValue(getDecoratedElement().getWidth());
        int height = toViewValue(getDecoratedElement().getHeight());

        AffineTransform transform = new AffineTransform();
        transform.rotate(position.getRotation(), position.getX(), position.getY());
        transform.translate(position.getX() - width / 2, position.getY() - height / 2);

        Shape rectangleShape = new java.awt.Rectangle(width, height);
        rectangleShape = transform.createTransformedShape(rectangleShape);
        g2d.fill(rectangleShape);
    }

}
