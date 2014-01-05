package org.adarrivi.physicsframework.adapter.physics.model.force;

import org.jbox2d.dynamics.Body;

public interface WorldForce {

    void applyForce(Body body);

}
