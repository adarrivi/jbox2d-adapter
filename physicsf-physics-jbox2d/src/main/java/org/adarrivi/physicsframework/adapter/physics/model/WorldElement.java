package org.adarrivi.physicsframework.adapter.physics.model;

import org.adarrivi.physicsframework.model.element.Position;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;

public interface WorldElement {

    Body addToWorld(World world, Position position);

}
