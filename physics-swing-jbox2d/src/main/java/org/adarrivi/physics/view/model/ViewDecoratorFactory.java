package org.adarrivi.physics.view.model;

import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.PositionalElement;
import org.adarrivi.physics.model.element.Rectangle;

public class ViewDecoratorFactory {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    public ViewDecoratorFactory(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    public ViewPositionalElementDecorator<?> decoratePositionalElement(PositionalElement positionalElement) {
        if (positionalElement instanceof Circle) {
            return new ViewCircle((Circle) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        if (positionalElement instanceof Rectangle) {
            return new ViewRectangle((Rectangle) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        return null;
    }

}
