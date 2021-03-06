package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;

public abstract class ViewPositionalElementDecorator<P extends PositionalElement> implements SwingDrawable {

    private P decoratedElement;

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    protected ViewPositionalElementDecorator(P decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.decoratedElement = decoratedElement;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    protected P getDecoratedElement() {
        return decoratedElement;
    }

    private ViewPosition toViewPosition(Position worldPosition) {
        double offsetX = (screenWidth / 2) / pixelsPerMeter;
        double offsetY = (screenHeight / 2) / pixelsPerMeter;
        Double drawPositionX = (worldPosition.getX() + offsetX) * pixelsPerMeter;
        Double drawPositionY = (-worldPosition.getY() + offsetY) * pixelsPerMeter;
        return new ViewPosition(drawPositionX.intValue(), drawPositionY.intValue(), -worldPosition.getRotation());
    }

    protected int toViewValue(float worldValue) {
        Float screenValue = worldValue * pixelsPerMeter;
        return screenValue.intValue();
    }

    @Override
    public final void drawYourself(Graphics2D g2d) {
        ViewPosition position = toViewPosition(getDecoratedElement().getPosition());
        AffineTransform rotatedAffineTransform = new AffineTransform();
        rotatedAffineTransform.rotate(position.getRotation(), position.getX(), position.getY());
        drawYourselfAtPosition(g2d, position, rotatedAffineTransform);
    }

    protected abstract void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position, AffineTransform rotatedAffineTransform);

}
