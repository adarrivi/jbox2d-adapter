package org.adarrivi.physicsframework.physic.adapter;

import java.util.Collection;

import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.Force;

public interface PhysicsAdapter {

    <P extends PositionalElement> void createElement(P element, Position position);

    <P extends PositionalElement> Position getLatestPosition(P element);

    <P extends PositionalElement> void destroy(P element);

    <F extends Force, P extends PositionalElement> void applyForce(F force, P element);

    void createSandBox(SandBox sandBox);

    void step(SandBox sandBox);

    Collection<? extends PositionalElement> getAllElements();

}
