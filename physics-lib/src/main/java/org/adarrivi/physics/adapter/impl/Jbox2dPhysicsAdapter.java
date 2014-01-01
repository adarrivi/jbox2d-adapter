package org.adarrivi.physics.adapter.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.adarrivi.physics.adapter.PhysicsAdapter;
import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.PhysicalElement;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.Rectangle;
import org.adarrivi.physics.model.element.SandBox;
import org.adarrivi.physics.model.force.Force;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class Jbox2dPhysicsAdapter implements PhysicsAdapter {

    private Map<PhysicalElement, Body> elementHashMap = new ConcurrentHashMap<>();
    private Jbox2dElementFactory jbox2dElementFactory;

    @Override
    public <E extends PhysicalElement> void createElement(E element, Position position) {
        Body createdBody = null;
        if (element instanceof Circle) {
            Circle circle = (Circle) element;
            createdBody = jbox2dElementFactory.createCircle(toVec2(position), circle.getRadius());
        }
        if (element instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) element;
            createdBody = jbox2dElementFactory.createStaticRectangle(toVec2(position), rectangle.getWidth(), rectangle.getHeight());
        }
        if (createdBody != null) {
            elementHashMap.put(element, createdBody);
        }
    }

    private Vec2 toVec2(Position position) {
        return new Vec2(position.getX(), position.getY());
    }

    @Override
    public <E extends PhysicalElement> Position getLatestPosition(E element) {
        Body body = elementHashMap.get(element);
        return toPosition(body.getPosition());
    }

    private Position toPosition(Vec2 vector) {
        return new Position(vector.x, vector.y);
    }

    @Override
    public <E extends PhysicalElement> void destroy(E element) {
        jbox2dElementFactory.destroyBody(elementHashMap.get(element));
    }

    @Override
    public <F extends Force, E extends PhysicalElement> void applyForce(F force, E element) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createSandBox(SandBox sandBox) {
        jbox2dElementFactory = new Jbox2dElementFactory();
        jbox2dElementFactory.createWorld(sandBox.hasEarthGravity());
    }

    @Override
    public void step(SandBox sandBox) {
        jbox2dElementFactory.stepWorld();
    }

    @Override
    public Collection<? extends PhysicalElement> getAllElements() {
        return new HashSet<>(elementHashMap.keySet());
    }

}
