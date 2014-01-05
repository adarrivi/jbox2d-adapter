package candy;

import org.adarrivi.physicsframework.adapter.view.model.ViewDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.CandyBall;
import org.adarrivi.physicsframework.model.CandyBar;
import org.adarrivi.physicsframework.model.CandySquare;
import org.adarrivi.physicsframework.model.element.PositionalElement;

public class ViewCandyDecoratorFactory implements ViewDecoratorFactory {

    private int screenWidth;
    private int screenHeight;
    private int pixelsPerMeter;

    public ViewCandyDecoratorFactory(int screenWidth, int screenHeight, int pixelsPerMeter) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.pixelsPerMeter = pixelsPerMeter;
    }

    @Override
    public ViewPositionalElementDecorator<?> decoratePositionalElement(PositionalElement positionalElement) {
        if (positionalElement instanceof CandyBall) {
            return new ViewCandyBall((CandyBall) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        if (positionalElement instanceof CandyBar) {
            return new ViewCandyBar((CandyBar) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }
        if (positionalElement instanceof CandySquare) {
            return new ViewCandySquare((CandySquare) positionalElement, screenWidth, screenHeight, pixelsPerMeter);
        }

        return null;
    }
}
