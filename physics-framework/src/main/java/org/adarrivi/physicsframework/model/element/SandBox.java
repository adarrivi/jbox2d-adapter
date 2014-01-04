package org.adarrivi.physicsframework.model.element;

import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SandBox {

    private static final long DEFAULT_STEP_SIMULATION_MS = 16;

    private PhysicsAdapter physicsAdapter;
    private boolean earthGravity;
    private long stepSimulationMs = DEFAULT_STEP_SIMULATION_MS;

    SandBox(PhysicsAdapter physicsAdapter, boolean earthGravity) {
        this.physicsAdapter = physicsAdapter;
        this.earthGravity = earthGravity;
    }

    public boolean hasEarthGravity() {
        return earthGravity;
    }

    public void step() {
        physicsAdapter.step(this);
    }

    public long getStepSimulationMs() {
        return stepSimulationMs;
    }

    public void setStepSimulationMs(long stepSimulationMs) {
        this.stepSimulationMs = stepSimulationMs;
    }
}
