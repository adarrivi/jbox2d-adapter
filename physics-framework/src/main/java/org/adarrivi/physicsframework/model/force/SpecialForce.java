package org.adarrivi.physicsframework.model.force;

import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SpecialForce extends Force {

    SpecialForce(PhysicsAdapter physicsAdapter) {
        super(physicsAdapter);
    }

    public <E extends Element> void destroy(E element) {
        getPhysicsAdapter().destroy(element);
    }

}
