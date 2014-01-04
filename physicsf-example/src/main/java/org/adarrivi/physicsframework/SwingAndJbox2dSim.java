package org.adarrivi.physicsframework;

import org.adarrivi.physicsframework.adapter.physics.Jbox2dPhysicsAdapter;
import org.adarrivi.physicsframework.adapter.physics.model.PhysicsDecoratorFactory;
import org.adarrivi.physicsframework.executor.SteadyExecutor;
import org.adarrivi.physicsframework.model.SpecialElementFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SwingAndJbox2dSim {

    public static void main(String[] args) {
        new SwingAndJbox2dSim().start();
    }

    public void start() {
        PhysicsDecoratorFactory physicsDecoratorFactory = new PhysicsDecoratorFactory();
        PhysicsAdapter physicsAdapter = new Jbox2dPhysicsAdapter(physicsDecoratorFactory);
        DoublePanelFrame viewFrame = new DoublePanelFrame(physicsAdapter);
        SpecialElementFactory elementFactory = new SpecialElementFactory(physicsAdapter);
        SandBox sandBox = elementFactory.createEarthSandBox();
        Position rectanglePosition = new Position(0f, 0f);
        rectanglePosition.setRotation(-0.3f);
        elementFactory.createPlatform(rectanglePosition);

        ForceFactory forceFactory = new ForceFactory(physicsAdapter);
        StepCommand stepCommand = new StepCommand(elementFactory, forceFactory, sandBox, viewFrame);
        stepCommand.createInitialElements();
        SteadyExecutor steadyExecutor = new SteadyExecutor(stepCommand);

        steadyExecutor.executeNoFasterThan(60);
    }

}
