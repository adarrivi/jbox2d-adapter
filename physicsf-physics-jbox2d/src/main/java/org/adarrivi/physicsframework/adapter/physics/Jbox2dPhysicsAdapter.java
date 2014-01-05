package org.adarrivi.physicsframework.adapter.physics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

import org.adarrivi.physicsframework.adapter.physics.model.element.Jbox2dPhysicsDecoratorFactory;
import org.adarrivi.physicsframework.adapter.physics.model.element.PhysicsElementDecorator;
import org.adarrivi.physicsframework.adapter.physics.model.force.Jbox2dPhysicsForceDecoratorFactory;
import org.adarrivi.physicsframework.adapter.physics.model.force.PhysicsForceDecorator;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.Force;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public class Jbox2dPhysicsAdapter implements PhysicsAdapter {

    private static final int POSITION_ITERATIONS = 3;
    private static final int VELOCITY_ITERATIONS = 8;
    private ConcurrentHashMap<PositionalElement, Body> elementHashMap = new ConcurrentHashMap<>();
    private Jbox2dPhysicsDecoratorFactory physicsDecoratorFactory;
    private Jbox2dPhysicsForceDecoratorFactory forcesDecoratorFactory;
    private World world;

    public Jbox2dPhysicsAdapter(Jbox2dPhysicsDecoratorFactory physicsDecoratorFactory,
            Jbox2dPhysicsForceDecoratorFactory forcesDecoratorFactory) {
        this.physicsDecoratorFactory = physicsDecoratorFactory;
        this.forcesDecoratorFactory = forcesDecoratorFactory;
    }

    @Override
    public void createElement(PositionalElement element) {
        PhysicsElementDecorator<?> physicsElement = physicsDecoratorFactory.decoratePositionalElement(element);
        Body createdBody = physicsElement.addToWorld(world);
        elementHashMap.putIfAbsent(element, createdBody);
    }

    @Override
    public Position getLatestPosition(PositionalElement element) {
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
    public void destroy(PositionalElement element) {
        world.destroyBody(elementHashMap.get(element));
    }

    @Override
    public void applyForce(Force force, PositionalElement element) {
        PhysicsForceDecorator<?> forceDecorator = forcesDecoratorFactory.createForceDecorator(force);
        Body body = elementHashMap.get(element);
        if (body != null) {
            forceDecorator.applyForce(body);
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
        updateAllElementPositions();
    }

    private void updateAllElementPositions() {
        for (Entry<PositionalElement, Body> entry : elementHashMap.entrySet()) {
            Body body = entry.getValue();
            PositionalElement element = entry.getKey();
            element.updatePosition(toPosition(body));
        }
    }

    @Override
    public Collection<? extends PositionalElement> getAllElements() {
        return new HashSet<>(elementHashMap.keySet());
    }

}
