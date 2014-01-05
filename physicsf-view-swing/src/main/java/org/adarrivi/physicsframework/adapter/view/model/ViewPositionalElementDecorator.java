package org.adarrivi.physicsframework.adapter.view.model;

import java.awt.Graphics2D;

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
        Position latestPosition = getDecoratedElement().getPosition();
        drawYourselfAtPosition(g2d, toViewPosition(latestPosition));
    }

    protected abstract void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position);

}
