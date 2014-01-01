package org.adarrivi.physics.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import org.adarrivi.physics.Utils;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.collision.shapes.ShapeType;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.Fixture;

public class SandboxPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public SandboxPanel(int width, int height) {
        super();
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setSize(width, height);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D g2d = (Graphics2D) graphics;
        for (Body body = Utils.world.getBodyList(); body != null; body = body.getNext()) {
            for (Fixture fixture = body.getFixtureList(); fixture != null; fixture = fixture.getNext()) {
                Vec2 vec2 = body.getPosition();
                if (fixture.getType() == ShapeType.CIRCLE) {
                    drawCircle(g2d, vec2);
                } else if (fixture.getType() == ShapeType.POLYGON) {
                    drawPolygon(g2d, vec2, (PolygonShape) fixture.getShape());
                }
            }
        }
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private void drawCircle(Graphics2D g2d, Vec2 vec2) {
        g2d.setColor(Color.BLUE);
        ScreenPosition screenVector = Utils.convertWorldToScreen(vec2);
        Ellipse2D.Double circle = new Ellipse2D.Double(screenVector.getX(), screenVector.getY(), 10, 10);
        g2d.fill(circle);
    }

    private void drawPolygon(Graphics2D g2d, Vec2 polygonCenterPosition, PolygonShape polygonShape) {
        g2d.setColor(Color.GREEN);
        int vertexCount = polygonShape.m_count;
        Vec2[] relativeVertexPositions = polygonShape.m_vertices;
        int[] intX = new int[vertexCount];
        int[] intY = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            ScreenPosition vertexPosition = Utils.convertWorldToScreen(relativeVertexPositions[i].add(polygonCenterPosition));
            intX[i] = vertexPosition.getX();
            intY[i] = vertexPosition.getY();
        }
        g2d.fillPolygon(intX, intY, vertexCount);
    }

}
