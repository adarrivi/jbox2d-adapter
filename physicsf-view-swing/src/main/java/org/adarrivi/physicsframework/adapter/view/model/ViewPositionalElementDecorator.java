package org.adarrivi.physicsframework.adapter.view.model;

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

    protected ViewPosition toViewPosition(Position worldPosition) {
        double offsetX = (screenWidth / 2) / pixelsPerMeter;
        double offsetY = (screenHeight / 2) / pixelsPerMeter;
        Double drawPositionX = (worldPosition.getX() + offsetX) * pixelsPerMeter;
        Double drawPositionY = (-worldPosition.getY() + offsetY) * pixelsPerMeter;
        return new ViewPosition(drawPositionX.intValue(), drawPositionY.intValue());
    }

    protected int toViewValue(float worldValue) {
        Float screenValue = worldValue * pixelsPerMeter;
        return screenValue.intValue();
    }

}
