package org.adarrivi.physicsframework;

import org.adarrivi.physicsframework.adapter.physics.Jbox2dPhysicsAdapter;
import org.adarrivi.physicsframework.adapter.physics.model.PhysicsDecoratorFactory;
import org.adarrivi.physicsframework.adapter.view.panel.PhysicsViewFrame;
import org.adarrivi.physicsframework.executor.SteadyExecutor;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.ElementFactory;
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
        PhysicsViewFrame viewFrame = new PhysicsViewFrame(physicsAdapter);
        ElementFactory elementFactory = new ElementFactory(physicsAdapter);
        SandBox sandBox = elementFactory.createEarthSandBox();
        elementFactory.createRectangle(new Position(0f, 0f), 12f, 1f, DynamicType.STATIC);

        ForceFactory forceFactory = new ForceFactory(physicsAdapter);
        StepCommand stepCommand = new StepCommand(elementFactory, forceFactory, sandBox, viewFrame);
        stepCommand.createInitialElements();
        SteadyExecutor steadyExecutor = new SteadyExecutor(stepCommand);

        steadyExecutor.executeNoFasterThan(60);
    }

}
