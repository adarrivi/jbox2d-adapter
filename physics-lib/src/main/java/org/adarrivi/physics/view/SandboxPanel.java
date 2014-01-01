package org.adarrivi.physics.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JPanel;

import org.adarrivi.physics.adapter.PhysicsAdapter;
import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.PhysicalElement;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.Rectangle;

public class SandboxPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private PhysicsAdapter physicsAdapter;
    private WorldScreenConverter worldScreenConverter;

    public SandboxPanel(PhysicsAdapter physicsAdapter, WorldScreenConverter worldScreenConverter) {
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(worldScreenConverter.getScreenWidth(), worldScreenConverter.getScreenHeight());
        this.physicsAdapter = physicsAdapter;
        this.worldScreenConverter = worldScreenConverter;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        for (PhysicalElement element : physicsAdapter.getAllElements()) {
            Position position = element.getPosition();
            if (element instanceof Circle) {
                Circle circle = (Circle) element;
                drawCircle(g2d, position, circle.getRadius());
            }
            if (element instanceof Rectangle) {
                drawRectangle(g2d, (Rectangle) element);
            }
        }
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private void drawCircle(Graphics2D g2d, Position position, float radius) {
        g2d.setColor(Color.BLUE);
        ScreenPosition screenPosition = worldScreenConverter.toScreenPosition(position);
        int screenRadius = worldScreenConverter.toScreenValue(radius);
        Ellipse2D.Double circle = new Ellipse2D.Double(screenPosition.getX() - screenRadius, screenPosition.getY() - screenRadius,
                2 * screenRadius, 2 * screenRadius);
        g2d.fill(circle);
    }

    private void drawRectangle(Graphics2D g2d, Rectangle rectangle) {
        g2d.setColor(Color.GREEN);
        List<Position> vertexList = rectangle.getVertexList();
        int vertexCount = vertexList.size();
        int[] intX = new int[vertexCount];
        int[] intY = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ScreenPosition vertexPosition = worldScreenConverter.toScreenPosition(vertexList.get(i));
            intX[i] = vertexPosition.getX();
            intY[i] = vertexPosition.getY();
        }
        g2d.fillPolygon(intX, intY, vertexCount);
    }

}
