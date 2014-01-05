package org.adarrivi.physicsframework.model.element;


public class SandBox {

    private static final long DEFAULT_STEP_SIMULATION_MS = 16;

    private boolean earthGravity;
    private long stepSimulationMs = DEFAULT_STEP_SIMULATION_MS;

    SandBox(boolean earthGravity) {
        this.earthGravity = earthGravity;
    }

    public boolean hasEarthGravity() {
        return earthGravity;
    }

    public long getStepSimulationMs() {
        return stepSimulationMs;
    }

    public void setStepSimulationMs(long stepSimulationMs) {
        this.stepSimulationMs = stepSimulationMs;
    }
}
