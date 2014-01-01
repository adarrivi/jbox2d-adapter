package org.adarrivi.physics.model.force;

import org.adarrivi.physics.adapter.PhysicsAdapter;
import org.adarrivi.physics.model.element.PhysicalElement;

public class SpecialForce extends Force {

    SpecialForce(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter);
    }

    public <E extends PhysicalElement> void destroy(E element) {
        getPhysicsAdapter().destroy(element);
    }

}
