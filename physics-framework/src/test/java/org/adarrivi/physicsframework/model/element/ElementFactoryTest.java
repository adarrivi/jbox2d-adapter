package org.adarrivi.physicsframework.model.element;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ElementFactoryTest {

    private static final Position POSITION = new Position(0, 0);

    @Mock
    private PhysicsAdapter physicsAdapter;

    @InjectMocks
    private ElementFactory victim = new ElementFactory(physicsAdapter);

    // output
    private PhysicsAdapter physicsAdapterResult;

    @Test
    public void createEarthSandBox_InvokesPyAdCreateSandbox() {
        whenCreateEarthSandbox();
        thenShouldInvokePyAdCreateSandbox();
    }

    private void whenCreateEarthSandbox() {
        victim.createEarthSandBox();
    }

    private void thenShouldInvokePyAdCreateSandbox() {
        verify(physicsAdapter).createSandBox(any(SandBox.class));
    }

    @Test
    public void createCircle_InvokesPyAdCreateElement() {
        whenCreateCircle();
        thenShouldInvokeCreateElement();
    }

    private void whenCreateCircle() {
        victim.createCircle(POSITION, 0, DynamicType.STATIC);
    }

    private void thenShouldInvokeCreateElement() {
        verify(physicsAdapter).createElement(any(Element.class), eq(POSITION));
    }

    @Test
    public void createRectangle_InvokesPyAdCreateElement() {
        whenCreateRectangle();
        thenShouldInvokeCreateElement();
    }

    private void whenCreateRectangle() {
        victim.createRectangle(POSITION, 0, 0, DynamicType.DYNAMIC);
    }

    @Test
    public void getPhysicsAdapter_ReturnsPyAdFromConstructor() {
        whenGetPhysicsAdapter();
        thenPyAdShouldBe(physicsAdapter);
    }

    private void whenGetPhysicsAdapter() {
        physicsAdapterResult = victim.getPhysicsAdapter();
    }

    private void thenPyAdShouldBe(PhysicsAdapter expectedPhysicsAdapter) {
        Assert.assertEquals(expectedPhysicsAdapter, physicsAdapterResult);
    }

}
