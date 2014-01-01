package org.adarrivi.physics.physic.adapter;

import java.util.Collection;

import org.adarrivi.physics.model.element.PositionalElement;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.SandBox;
import org.adarrivi.physics.model.force.Force;

public interface PhysicsAdapter {

    <P extends PositionalElement> void createElement(P element, Position position);

    <P extends PositionalElement> Position getLatestPosition(P element);

    <P extends PositionalElement> void destroy(P element);

    <F extends Force, P extends PositionalElement> void applyForce(F force, P element);

    void createSandBox(SandBox sandBox);

    void step(SandBox sandBox);

    Collection<? extends PositionalElement> getAllElements();

}
