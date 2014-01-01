package org.adarrivi.physics.physic.adapter.jbox2d;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.adarrivi.physics.model.element.Circle;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.PositionalElement;
import org.adarrivi.physics.model.element.Rectangle;
import org.adarrivi.physics.model.element.SandBox;
import org.adarrivi.physics.model.force.Force;
import org.adarrivi.physics.physic.adapter.PhysicsAdapter;
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
        return toPosition(body.getPosition());
    }

    private Position toPosition(Vec2 vector) {
        return new Position(vector.x, vector.y);
    }

    @Override
    public <P extends PositionalElement> void destroy(P element) {
        jbox2dElementFactory.destroyBody(elementHashMap.get(element));
    }

    @Override
    public <F extends Force, P extends PositionalElement> void applyForce(F force, P element) {
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
    public Collection<? extends PositionalElement> getAllElements() {
        return new HashSet<>(elementHashMap.keySet());
    }

}
