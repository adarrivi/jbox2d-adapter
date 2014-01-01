package org.adarrivi.physics.adapter.impl;

import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.BodyDef;
import org.jbox2d.dynamics.BodyType;
import org.jbox2d.dynamics.FixtureDef;
import org.jbox2d.dynamics.World;

class Jbox2dElementFactory {

    private static final float EARTH_GRAVITY = -10f;
    private World world;

    void createWorld(boolean hasEarthGravity) {
        // TODO verify world doesn't exist
        Vec2 gravityVector = new Vec2(0f, 0f);
        if (hasEarthGravity) {
            gravityVector.y = EARTH_GRAVITY;
        }
        world = new World(gravityVector);
        world.setContinuousPhysics(true);
    }

    Body createCircle(Vec2 position, float radius) {
        CircleShape circle = new CircleShape();
        circle.m_radius = radius;

        FixtureDef fd = new FixtureDef();
        fd.shape = circle;
        fd.density = 1.0f;
        fd.friction = 0.9f;

        BodyDef bd = new BodyDef();
        bd.type = BodyType.DYNAMIC;
        bd.position = position;
        Body body = world.createBody(bd);
        body.createFixture(fd);
        return body;
    }

    Body createStaticRectangle(Vec2 position, float width, float height) {
        FixtureDef fd = new FixtureDef();
        PolygonShape sd = new PolygonShape();
        sd.setAsBox(width / 2, height / 2);
        fd.shape = sd;
        BodyDef bd = new BodyDef();
        bd.position = position;
        bd.type = BodyType.STATIC;
        Body body = world.createBody(bd);
        body.createFixture(fd);
        return body;
    }

    // private Vec2 getLinearVelocity(double randomAngle, int magnitude) {
    // Vec2 vec2 = new Vec2((float) Math.cos(randomAngle), (float)
    // Math.sin(randomAngle));
    // return vec2.mul(magnitude);
    // }
    //
    // private double getRandomAngle() {
    // Random random = new Random();
    // return random.nextDouble() * Math.PI * 2;
    // }

    void destroyBody(Body body) {
        world.destroyBody(body);
    }

    void stepWorld() {
        world.step(1 / 60f, 8, 3);
    }

}
