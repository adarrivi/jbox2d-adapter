package org.adarrivi.physicsframework;

import org.adarrivi.physicsframework.adapter.view.panel.PhysicsViewFrame;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.model.element.ElementFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.model.force.LinearForce;

public class StepCommand implements Runnable {

    private static final int STEPS_BETWEEN_BALLS = 50;
    private int skipBallCreation;
    private boolean pushLeft;
    private ElementFactory elementFactory;
    private ForceFactory forceFactory;
    private LinearForce rightPush;
    private LinearForce leftPush;
    private SandBox sandBox;
    private PhysicsViewFrame viewFrame;

    private int shape;

    public StepCommand(ElementFactory elementFactory, ForceFactory forceFactory, SandBox sandBox, PhysicsViewFrame viewFrame) {
        this.elementFactory = elementFactory;
        this.forceFactory = forceFactory;
        this.sandBox = sandBox;
        this.viewFrame = viewFrame;
    }

    public void createInitialElements() {
        rightPush = forceFactory.createLinearForce(50f, 1);
        leftPush = forceFactory.createLinearForce(50f, 2);
    }

    @Override
    public void run() {
        if (skipBallCreation % STEPS_BETWEEN_BALLS == 0) {
            Element element;
            if (shape == 1) {
                element = elementFactory.createRectangle(new Position(0f, 5f), 1f, 1f, DynamicType.DYNAMIC);
            } else {
                shape = 0;
                element = elementFactory.createCircle(new Position(0f, 5f), 0.5f, DynamicType.DYNAMIC);
            }
            if (pushLeft) {
                leftPush.applyOn(element);
            } else {
                rightPush.applyOn(element);
            }
            pushLeft = !pushLeft;
            shape++;
        }

        skipBallCreation++;
        sandBox.step();
        viewFrame.repaint();
    }
}
