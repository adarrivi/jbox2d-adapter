package org.adarrivi.physicsframework;

import org.adarrivi.physicsframework.adapter.physics.Jbox2dPhysicsAdapter;
import org.adarrivi.physicsframework.adapter.physics.model.Jbox2dPhysicsDecoratorFactory;
import org.adarrivi.physicsframework.executor.SteadyExecutor;
import org.adarrivi.physicsframework.model.CandyFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

/**
 * Simulation using Jbox2d engine and two different swing visualisations: by
 * shapes and by images.
 * 
 * @author adarrivi
 * 
 */
public class DoubleViewJboxSimulation {

    private static final int PIXELS_PER_METER = 25;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static void main(String[] args) {
        new DoubleViewJboxSimulation().start();
    }

    void start() {
        Jbox2dPhysicsDecoratorFactory physicsDecoratorFactory = new Jbox2dPhysicsDecoratorFactory();
        PhysicsAdapter physicsAdapter = new Jbox2dPhysicsAdapter(physicsDecoratorFactory);
        DoublePanelFrame viewFrame = new DoublePanelFrame(physicsAdapter);
        viewFrame.setFrameSize(WIDTH, HEIGHT, PIXELS_PER_METER);
        CandyFactory candyFactory = new CandyFactory(physicsAdapter);
        SandBox sandBox = candyFactory.createEarthSandBox();
        Position barPosition = new Position(0f, 0f);
        barPosition.setRotation(-0.3f);
        candyFactory.createCandyBar(barPosition);

        ForceFactory forceFactory = new ForceFactory(physicsAdapter);
        StepCommand stepCommand = new StepCommand(candyFactory, forceFactory, sandBox, viewFrame);
        SteadyExecutor steadyExecutor = new SteadyExecutor(stepCommand);

        steadyExecutor.executeNoFasterThan(60);
    }

}
