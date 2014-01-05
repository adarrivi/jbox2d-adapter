package org.adarrivi.physicsframework.physic.adapter;

import java.util.Collection;

import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.PositionalElement;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.Force;

/**
 * Defines the API that any physics engine must implement to be used
 * 
 * @author adarrivi
 * 
 */
public interface PhysicsAdapter {

    void createElement(PositionalElement element);

    Position getLatestPosition(PositionalElement element);

    void destroy(PositionalElement element);

    void applyForce(Force force, PositionalElement element);

    void createSandBox(SandBox sandBox);

    void step(SandBox sandBox);

    Collection<? extends PositionalElement> getAllElements();

}
