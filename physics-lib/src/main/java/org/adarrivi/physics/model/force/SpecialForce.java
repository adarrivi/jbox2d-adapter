package org.adarrivi.physics.model.force;

import org.adarrivi.physics.model.element.Element;
import org.adarrivi.physics.physic.adapter.PhysicsAdapter;

public class SpecialForce extends Force {

    SpecialForce(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter);
    }

    public <E extends Element> void destroy(E element) {
        getPhysicsAdapter().destroy(element);
    }

}
