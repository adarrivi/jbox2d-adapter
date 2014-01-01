package org.adarrivi.physics.adapter;

import java.util.Collection;

import org.adarrivi.physics.model.element.PhysicalElement;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.SandBox;
import org.adarrivi.physics.model.force.Force;

public interface PhysicsAdapter {

    <E extends PhysicalElement> void createElement(E element, Position position);

    <E extends PhysicalElement> Position getLatestPosition(E element);

    <E extends PhysicalElement> void destroy(E element);

    <F extends Force, E extends PhysicalElement> void applyForce(F force, E element);

    void createSandBox(SandBox sandBox);

    void step(SandBox sandBox);

    Collection<? extends PhysicalElement> getAllElements();

}
