package candy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import org.adarrivi.physicsframework.adapter.view.model.ViewPosition;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.CandyBall;

public class ViewCandyBall extends ViewPositionalElementDecorator<CandyBall> {

    private static final Image CANDY_BALL_IMG = new ImageIcon(ViewCandyBall.class.getResource("/images/candyball30x30.png")).getImage();

    protected ViewCandyBall(CandyBall decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfAtPosition(Graphics2D g2d, ViewPosition position, AffineTransform rotatedAffineTransform) {
        int viewRadius = toViewValue(getDecoratedElement().getRadius());
        rotatedAffineTransform.translate(position.getX() - viewRadius, position.getY() - viewRadius);
        g2d.drawImage(CANDY_BALL_IMG, rotatedAffineTransform, null);
    }

}
