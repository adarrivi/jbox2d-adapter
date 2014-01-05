package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SandBoxTest {

    private static final boolean EARTH_GRAVITY = true;
    private static final long DEFAULT_STEP_SIMULATION_MS = 16;

    @Mock
    private PhysicsAdapter physicsAdapter;

    @InjectMocks
    private SandBox victim = new SandBox(physicsAdapter, EARTH_GRAVITY);

    // output
    private boolean booleanResult;
    private long longResult;

    @Test
    public void hasEarthGravity_ReturnsContructorValue() {
        whenHasEarthGravity();
        thenBooleanResultShouldBe(EARTH_GRAVITY);
    }

    private void whenHasEarthGravity() {
        booleanResult = victim.hasEarthGravity();
    }

    private void thenBooleanResultShouldBe(boolean expectedValue) {
        Assert.assertEquals(expectedValue, booleanResult);
    }

    @Test
    public void getStepSimulationMs_NoSet_ReturnsDefaultValue() {
        whenGetStepSimulationMs();
        thenLongResultShouldBe(DEFAULT_STEP_SIMULATION_MS);
    }

    private void whenGetStepSimulationMs() {
        longResult = victim.getStepSimulationMs();
    }

    private void thenLongResultShouldBe(long expectedValue) {
        Assert.assertEquals(expectedValue, longResult);
    }

    @Test
    public void getStepSimulationMs_SetBefore_ReturnsValue() {
        whenSetStepSimulationMs(1);
        whenGetStepSimulationMs();
        thenLongResultShouldBe(1);
    }

    private void whenSetStepSimulationMs(long longValue) {
        victim.setStepSimulationMs(longValue);
    }

    @Test
    public void step_InvokesPyAdStep() {
        whenStep();
        thenShouldInvokePyAdStep();
    }

    private void whenStep() {
        victim.step();
    }

    private void thenShouldInvokePyAdStep() {
        Mockito.verify(physicsAdapter).step(victim);
    }

}
