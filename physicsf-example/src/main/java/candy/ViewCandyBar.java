package candy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import org.adarrivi.physicsframework.adapter.view.model.ViewPosition;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.CandyBar;

public class ViewCandyBar extends ViewPositionalElementDecorator<CandyBar> {

    private static final Image CANDY_BAR_IMG = new ImageIcon(ViewCandyBar.class.getResource("/images/candybar200x18.png")).getImage();

    protected ViewCandyBar(CandyBar decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position, AffineTransform rotatedAffineTransform) {
        int width = toViewValue(getDecoratedElement().getWidth());
        int height = toViewValue(getDecoratedElement().getHeight());

        rotatedAffineTransform.translate(position.getX() - width / 2, position.getY() - height / 2);
        g2d.drawImage(CANDY_BAR_IMG, rotatedAffineTransform, null);
    }

}
