package org.adarrivi.physicsframework.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import org.adarrivi.physicsframework.adapter.view.model.ViewPosition;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.element.Circle;

public class ImageCircle extends ViewPositionalElementDecorator<Circle> {

    private static final Image BLUE_CIRCLE_IMG = new ImageIcon(ImageCircle.class.getResource("/images/circle30x30.png")).getImage();

    protected ImageCircle(Circle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfPosition(Graphics2D g2d, ViewPosition position) {
        int viewRadius = toViewValue(getDecoratedElement().getRadius());
        AffineTransform transform = new AffineTransform();
        transform.rotate(position.getRotation(), position.getX(), position.getY());
        transform.translate(position.getX() - viewRadius, position.getY() - viewRadius);
        g2d.drawImage(BLUE_CIRCLE_IMG, transform, null);
    }

}
