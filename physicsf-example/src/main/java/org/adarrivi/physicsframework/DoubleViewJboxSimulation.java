package org.adarrivi.physicsframework;

import org.adarrivi.physicsframework.adapter.physics.Jbox2dPhysicsAdapter;
import org.adarrivi.physicsframework.adapter.physics.model.element.Jbox2dPhysicsDecoratorFactory;
import org.adarrivi.physicsframework.adapter.physics.model.force.Jbox2dPhysicsForceDecoratorFactory;
import org.adarrivi.physicsframework.executor.SteadyExecutor;
import org.adarrivi.physicsframework.model.CandyBar;
import org.adarrivi.physicsframework.model.CandyFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
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

    private PhysicsAdapter physicsAdapter;
    private CandyFactory candyFactory;

    public static void main(String[] args) {
        new DoubleViewJboxSimulation().start();
    }

    void start() {
        candyFactory = new CandyFactory();
        Jbox2dPhysicsDecoratorFactory physicsDecoratorFactory = new Jbox2dPhysicsDecoratorFactory();
        Jbox2dPhysicsForceDecoratorFactory forceDecoratorFactory = new Jbox2dPhysicsForceDecoratorFactory();
        physicsAdapter = new Jbox2dPhysicsAdapter(physicsDecoratorFactory, forceDecoratorFactory);
        DoublePanelFrame viewFrame = new DoublePanelFrame(physicsAdapter);
        viewFrame.setFrameSize(WIDTH, HEIGHT, PIXELS_PER_METER);

        SandBox sandBox = createSandBox();
        createCandyBars();

        DoubleViewStepCommand stepCommand = new DoubleViewStepCommand(physicsAdapter, candyFactory, sandBox, viewFrame);
        SteadyExecutor steadyExecutor = new SteadyExecutor(stepCommand);

        steadyExecutor.executeNoFasterThan(STEPS_PER_SECOND);
    }

    private SandBox createSandBox() {
        SandBox sandBox = candyFactory.createEarthSandBox();
        physicsAdapter.createSandBox(sandBox);
        return sandBox;
    }

    private void createCandyBars() {
        Position candyBar1Position = new Position(-3f, -3f);
        candyBar1Position.setRotation(-0.4f);
        CandyBar candyBar = candyFactory.createCandyBar(candyBar1Position);
        physicsAdapter.createElement(candyBar);
        Position candyBar2Position = new Position(3f, 3f);
        candyBar2Position.setRotation(0.4f);
        candyBar = candyFactory.createCandyBar(candyBar2Position);
        physicsAdapter.createElement(candyBar);
    }

}
