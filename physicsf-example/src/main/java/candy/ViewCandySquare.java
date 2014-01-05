package candy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import org.adarrivi.physicsframework.adapter.view.model.ViewPosition;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.CandySquare;

public class ViewCandySquare extends ViewPositionalElementDecorator<CandySquare> {

    private static final Image CANDY_SQUARE_IMG = new ImageIcon(ViewCandySquare.class.getResource("/images/candysquare30x30.png"))
            .getImage();

    protected ViewCandySquare(CandySquare decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position, AffineTransform rotatedAffineTransform) {
        int width = toViewValue(getDecoratedElement().getWidth());
        int height = toViewValue(getDecoratedElement().getHeight());

        rotatedAffineTransform.translate(position.getX() - width / 2, position.getY() - height / 2);
        g2d.drawImage(CANDY_SQUARE_IMG, rotatedAffineTransform, null);
    }

}
