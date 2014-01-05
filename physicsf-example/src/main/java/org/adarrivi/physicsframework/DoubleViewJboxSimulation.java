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

    private static final int STEPS_PER_SECOND = 60;
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
        Position candyBar1Position = new Position(-3f, -3f);
        candyBar1Position.setRotation(-0.4f);
        candyFactory.createCandyBar(candyBar1Position);
        Position candyBar2Position = new Position(3f, 3f);
        candyBar2Position.setRotation(0.4f);
        candyFactory.createCandyBar(candyBar2Position);

        ForceFactory forceFactory = new ForceFactory(physicsAdapter);
        DoubleViewStepCommand stepCommand = new DoubleViewStepCommand(candyFactory, forceFactory, sandBox, viewFrame);
        SteadyExecutor steadyExecutor = new SteadyExecutor(stepCommand);

        steadyExecutor.executeNoFasterThan(STEPS_PER_SECOND);
    }

}
