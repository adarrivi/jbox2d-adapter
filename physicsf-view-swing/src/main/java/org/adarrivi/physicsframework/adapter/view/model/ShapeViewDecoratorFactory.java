package org.adarrivi.physicsframework.adapter.view.model;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.Rectangle;

public class ShapeViewDecoratorFactory implements ViewDecoratorFactory {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    public ShapeViewDecoratorFactory(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    @Override
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
