package org.adarrivi.physicsframework.image;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;

import org.adarrivi.physicsframework.adapter.view.model.ViewPosition;
import org.adarrivi.physicsframework.adapter.view.model.ViewPositionalElementDecorator;
import org.adarrivi.physicsframework.model.RectangleType;
import org.adarrivi.physicsframework.model.SpecialRectangle;

public class ImageSpecialRectangle extends ViewPositionalElementDecorator<SpecialRectangle> {

    private static final Image SQUARE = new ImageIcon(ImageSpecialRectangle.class.getResource("/images/square30x30.png")).getImage();
    private static final Image PLATFORM = new ImageIcon(ImageSpecialRectangle.class.getResource("/images/platform200x20.png")).getImage();

    protected ImageSpecialRectangle(SpecialRectangle decoratedElement, int screenWidth, int screenHeight, int pixelsPerMeter) {
        super(decoratedElement, screenWidth, screenHeight, pixelsPerMeter);
    }

    @Override
    protected void drawYourselfPosition(Graphics2D g2d, ViewPosition position) {
        Image image;
        RectangleType type = getDecoratedElement().getType();
        if (RectangleType.PLATFORM.equals(type)) {
            image = PLATFORM;
        } else {
            image = SQUARE;
        }
        int width = toViewValue(getDecoratedElement().getWidth());
        int height = toViewValue(getDecoratedElement().getHeight());

        AffineTransform transform = new AffineTransform();
        transform.rotate(position.getRotation(), position.getX(), position.getY());
        transform.translate(position.getX() - width / 2, position.getY() - height / 2);
        g2d.drawImage(image, transform, null);
    }

}
