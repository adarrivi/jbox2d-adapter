package org.adarrivi.physics.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import org.adarrivi.physics.adapter.PhysicsAdapter;
import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.PhysicalElement;
import org.adarrivi.physics.model.element.Position;

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
        }
        // for (Body body = ViewUtils.world.getBodyList(); body != null; body =
        // body.getNext()) {
        // for (Fixture fixture = body.getFixtureList(); fixture != null;
        // fixture = fixture.getNext()) {
        // Vec2 vec2 = body.getPosition();
        // if (fixture.getType() == ShapeType.CIRCLE) {
        // drawCircle(g2d, vec2);
        // } else if (fixture.getType() == ShapeType.POLYGON) {
        // drawPolygon(g2d, vec2, (PolygonShape) fixture.getShape());
        // }
        // }
        // }
        Toolkit.getDefaultToolkit().sync();
        graphics.dispose();
    }

    private void drawCircle(Graphics2D g2d, Position position, float radius) {
        g2d.setColor(Color.BLUE);
        ScreenPosition screenVector = worldScreenConverter.toScreenPosition(position);
        int screenDiameter = worldScreenConverter.toScreenValue(radius) * 2;
        Ellipse2D.Double circle = new Ellipse2D.Double(screenVector.getX(), screenVector.getY(), screenDiameter, screenDiameter);
        g2d.fill(circle);
    }

    // private void drawPolygon(Graphics2D g2d, Vec2 polygonCenterPosition,
    // PolygonShape polygonShape) {
    // g2d.setColor(Color.GREEN);
    // int vertexCount = polygonShape.m_count;
    // Vec2[] relativeVertexPositions = polygonShape.m_vertices;
    // int[] intX = new int[vertexCount];
    // int[] intY = new int[vertexCount];
    // for (int i = 0; i < vertexCount; i++) {
    // ScreenPosition vertexPosition =
    // ViewUtils.convertWorldToScreen(relativeVertexPositions[i].add(polygonCenterPosition));
    // intX[i] = vertexPosition.getX();
    // intY[i] = vertexPosition.getY();
    // }
    // g2d.fillPolygon(intX, intY, vertexCount);
    // }

}
