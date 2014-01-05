package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ElementTest {

    @Mock
    private PhysicsAdapter physicsAdapter;

    private Element victim;

    // private

    private void givenElement() {
        victim = new Circle(physicsAdapter, DynamicType.DYNAMIC, 1);
    }

}
