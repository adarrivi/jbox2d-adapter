package org.adarrivi.physics;

import java.util.Random;

import org.adarrivi.physics.view.ScreenPosition;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

/**
 * 
 * @author
 */
public class Utils {
    private static final double PIXELS_PER_METER = 50.0;

    // Create a JBox2D world.
    public static World world;

    // Screen width and height
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static void createWorld() {
        world = new World(new Vec2(0.0f, -10.0f));
        world.setContinuousPhysics(true);
    }

    public static Body createCircle(Vec2 position) {
        CircleShape circle = new CircleShape();
        circle.m_radius = 0.4f;

        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 1.0f;
        fd.friction = 0.9f;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position = position;
        Body body = world.createBody(bd);
        body.setLinearVelocity(getLinearVelocity(getRandomAngle(), 1));
        body.createFixture(fd);
        return body;
    }

    public static void createFloor() {
        FixtureDef fd = new FixtureDef();
        PolygonShape sd = new PolygonShape();
        sd.setAsBox(4f, 0.1f);
        fd.shape = sd;

        BodyDef bd = new BodyDef();
        bd.position = new Vec2(0f, 0f);
        world.createBody(bd).createFixture(fd);
    }

    private static Vec2 getLinearVelocity(double randomAngle, int magnitude) {
        Vec2 vec2 = new Vec2((float) Math.cos(randomAngle), (float) Math.sin(randomAngle));
        return vec2.mul(magnitude);
    }

    private static double getRandomAngle() {
        Random random = new Random();
        return random.nextDouble() * Math.PI * 2;
    }

    public static ScreenPosition convertWorldToScreen(Vec2 worldVector) {
        double pixelPerMeter = PIXELS_PER_METER;
        double offsetX = (WIDTH / 2) / PIXELS_PER_METER;
        double offsetY = (HEIGHT / 2) / PIXELS_PER_METER;
        Double drawPositionX = (worldVector.x + offsetX) * pixelPerMeter;
        Double drawPositionY = (-worldVector.y + offsetY) * pixelPerMeter;
        return new ScreenPosition(drawPositionX.intValue(), drawPositionY.intValue());
    }
}
