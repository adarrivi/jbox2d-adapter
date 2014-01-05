package org.adarrivi.physicsframework.adapter.physics.model.element;

import org.adarrivi.physicsframework.model.element.Element;
import org.jbox2d.dynamics.World;
import org.junit.Assert;
import org.junit.Test;

public class Jbox2dElementDecoratorFactoryTest {

    private Jbox2dElementDecoratorFactory victim = new Jbox2dElementDecoratorFactory();

    // intput
    private Element element;

    // output
    private World worldResult;
    private PhysicsElementDecorator<?> elementDecoratorResult;

    @Test
    public void createWorld_DoesntReturnNull() {
        whenCreateWorld();
        thenWorldResultShouldNotBeNull();
    }

    private void whenCreateWorld() {
        worldResult = victim.createWorld(false);
    }

    private void thenWorldResultShouldNotBeNull() {
        Assert.assertNotNull(worldResult);
    }

    @Test
    public void decoratePositionalElement_Circle_DoesntReturnNull() {
        givenElement(new CircleStub());
        whenDecoratePositionalElement();
        thenElementDecoratorShouldNotBeNull();
    }

    private void givenElement(Element anElement) {
        element = anElement;
    }

    private void whenDecoratePositionalElement() {
        elementDecoratorResult = victim.decoratePositionalElement(element);
    }

    private void thenElementDecoratorShouldNotBeNull() {
        Assert.assertNotNull(elementDecoratorResult);
    }

    @Test
    public void decoratePositionalElement_Rectangle_DoesntReturnNull() {
        givenElement(new RectangleStub());
        whenDecoratePositionalElement();
        thenElementDecoratorShouldNotBeNull();
    }

    @Test
    public void decoratePositionalElement_UnknownElement_ReturnsNull() {
        givenElement(new UnknownElementStub());
        whenDecoratePositionalElement();
        thenElementDecoratorShouldBeNull();
    }

    private void thenElementDecoratorShouldBeNull() {
        Assert.assertNull(elementDecoratorResult);
    }

}
