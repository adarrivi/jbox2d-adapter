package org.adarrivi.physicsframework.adapter.physics;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.adarrivi.physicsframework.model.element.Circle;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.Rectangle;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.Force;
import org.adarrivi.physicsframework.model.force.LinearForce;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

public class Jbox2dPhysicsAdapter implements PhysicsAdapter {

    private Map<PositionalElement, Body> elementHashMap = new ConcurrentHashMap<>();
    private Jbox2dElementFactory jbox2dElementFactory;

    @Override
    public <P extends PositionalElement> void createElement(P element, Position position) {
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
        jbox2dElementFactory.destroyBody(elementHashMap.get(element));
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
        jbox2dElementFactory = new Jbox2dElementFactory();
        jbox2dElementFactory.createWorld(sandBox.hasEarthGravity());
    }

    @Override
    public void step(SandBox sandBox) {
        jbox2dElementFactory.stepWorld();
    }

    @Override
    public Collection<? extends PositionalElement> getAllElements() {
        return new HashSet<>(elementHashMap.keySet());
    }

}
