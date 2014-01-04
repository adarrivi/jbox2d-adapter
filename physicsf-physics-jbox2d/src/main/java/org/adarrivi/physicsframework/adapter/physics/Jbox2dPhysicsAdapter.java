package org.adarrivi.physicsframework.adapter.physics;

import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.adarrivi.physicsframework.adapter.physics.model.PhysicsDecoratorFactory;
import org.adarrivi.physicsframework.adapter.physics.model.PhysicsElementDecorator;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.Force;
import org.adarrivi.physicsframework.model.force.LinearForce;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class Jbox2dPhysicsAdapter implements PhysicsAdapter {

    private static final int POSITION_ITERATIONS = 3;
    private static final int VELOCITY_ITERATIONS = 8;
    private ConcurrentHashMap<PositionalElement, Body> elementHashMap = new ConcurrentHashMap<>();
    private PhysicsDecoratorFactory physicsDecoratorFactory;
    private World world;

    public Jbox2dPhysicsAdapter(PhysicsDecoratorFactory physicsDecoratorFactory) {
        this.physicsDecoratorFactory = physicsDecoratorFactory;
    }

    @Override
    public <P extends PositionalElement> void createElement(P element, Position position) {
        PhysicsElementDecorator<?> physicsElement = physicsDecoratorFactory.decoratePositionalElement(element);
        Body createdBody = physicsElement.addToWorld(world, position);
        elementHashMap.putIfAbsent(element, createdBody);
    }

    @Override
    public <P extends PositionalElement> Position getLatestPosition(P element) {
        Body body = elementHashMap.get(element);
        return toPosition(body);
    }

    private Position toPosition(Body body) {
        Vec2 vector = body.getPosition();
        Position position = new Position(vector.x, vector.y);
        position.setRotation(body.getAngle());
        return position;
    }

    @Override
    public <P extends PositionalElement> void destroy(P element) {
        world.destroyBody(elementHashMap.get(element));
    }

    @Override
    public <F extends Force, P extends PositionalElement> void applyForce(F force, P element) {
        if (force instanceof LinearForce) {
            LinearForce linearForce = (LinearForce) force;
            Body body = elementHashMap.get(element);
            Double xVector = linearForce.getMagnitud() * Math.cos(linearForce.getDirection());
            Double yVector = linearForce.getMagnitud() * Math.sin(linearForce.getDirection());
            Vec2 forceVector = new Vec2(xVector.floatValue(), yVector.floatValue());
            body.applyForceToCenter(forceVector);
        }
    }

    @Override
    public void createSandBox(SandBox sandBox) {
        world = physicsDecoratorFactory.createWorld(sandBox.hasEarthGravity());
    }

    @Override
    public void step(SandBox sandBox) {
        float milliseconsPerSecond = TimeUnit.SECONDS.toMillis(1);
        world.step(sandBox.getStepSimulationMs() / milliseconsPerSecond, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    @Override
    public Collection<? extends PositionalElement> getAllElements() {
        return new HashSet<>(elementHashMap.keySet());
    }

}
