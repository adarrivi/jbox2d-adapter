package org.adarrivi.physics.view.adapter.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.view.ViewPosition;

class ViewCircle extends ViewPositionalElementDecorator<Circle> {

    ViewCircle(Circle circle, WorldViewConverter worldViewConverter) {
        super(circle, worldViewConverter);
    }

    @Override
    public void drawYourself(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        ViewPosition viewPosition = getWorldViewConverter().toScreenPosition(getDecoratedElement().getPosition());
        int screenRadius = getWorldViewConverter().toScreenValue(getDecoratedElement().getRadius());
        Ellipse2D.Double circle = new Ellipse2D.Double(viewPosition.getX() - screenRadius, viewPosition.getY() - screenRadius,
                2 * screenRadius, 2 * screenRadius);
        g2d.fill(circle);
    }

}
