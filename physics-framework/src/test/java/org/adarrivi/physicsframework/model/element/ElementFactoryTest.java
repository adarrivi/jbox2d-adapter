package org.adarrivi.physicsframework.model.element;

import org.junit.Assert;
import org.junit.Test;

public class ElementFactoryTest {

    private static final Position POSITION = new Position(0, 0);

    private ElementFactory victim = new ElementFactory();

    // output
    private Element elementResult;
    private SandBox sandBoxResult;

    @Test
    public void createEarthSandBox_DoesntReturnNull() {
        whenCreateEarthSandbox();
        thenSandboxResultCannotBeNull();
    }

    private void whenCreateEarthSandbox() {
        sandBoxResult = victim.createEarthSandBox();
    }

    private void thenSandboxResultCannotBeNull() {
        Assert.assertNotNull(sandBoxResult);
    }

    @Test
    public void createCircle_DoesntReturnNull() {
        whenCreateCircle();
        thenShouldCreateAnElement();
    }

    private void whenCreateCircle() {
        elementResult = victim.createCircle(POSITION, 0, DynamicType.STATIC);
    }

    private void thenShouldCreateAnElement() {
        Assert.assertNotNull(elementResult);
    }

    @Test
    public void createRectangle_InvokesPyAdCreateElement() {
        whenCreateRectangle();
        thenShouldCreateAnElement();
    }

    private void whenCreateRectangle() {
        elementResult = victim.createRectangle(POSITION, 0, 0, DynamicType.DYNAMIC);
    }

}
