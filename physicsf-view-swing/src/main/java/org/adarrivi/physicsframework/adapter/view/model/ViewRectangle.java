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
    protected void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position, AffineTransform rotatedAffineTransform) {
        int width = toViewValue(getDecoratedElement().getWidth());
        int height = toViewValue(getDecoratedElement().getHeight());

        rotatedAffineTransform.translate(position.getX() - width / 2, position.getY() - height / 2);

        Shape rectangleShape = new java.awt.Rectangle(width, height);
        rectangleShape = rotatedAffineTransform.createTransformedShape(rectangleShape);
        g2d.setColor(Color.GREEN);
        g2d.draw(rectangleShape);
    }

}
