package org.adarrivi.physicsframework.image;

import org.adarrivi.physicsframework.adapter.view.model.ViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.SpecialRectangle;
import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.PositionalElement;

public class ImageDecoratorFactory implements ViewDecoratorFactory {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    public ImageDecoratorFactory(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    @Override
    public ViewPositionalElementDecorator<?> decoratePositionalElement(PositionalElement positionalElement) {
        if (positionalElement instanceof Circle) {
            return new ImageCircle((Circle) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        if (positionalElement instanceof SpecialRectangle) {
            return new ImageSpecialRectangle((SpecialRectangle) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        return null;
    }
}
