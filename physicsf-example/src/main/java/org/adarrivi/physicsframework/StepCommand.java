package org.adarrivi.physicsframework;

import javax.swing.JFrame;

import org.adarrivi.physicsframework.model.SpecialElementFactory;
import org.adarrivi.physicsframework.model.element.DynamicType;
import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.model.force.LinearForce;

public class StepCommand implements Runnable {

    private static final int STEPS_BETWEEN_BALLS = 50;
    private int skipBallCreation;
    private boolean pushLeft;
    private SpecialElementFactory elementFactory;
    private ForceFactory forceFactory;
    private LinearForce rightPush;
    private LinearForce leftPush;
    private SandBox sandBox;
    private JFrame viewFrame;

    private int shape;

    public StepCommand(SpecialElementFactory elementFactory, ForceFactory forceFactory, SandBox sandBox, JFrame viewFrame) {
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
                element = elementFactory.createCircle(new Position(0f, 5f), 0.6f, DynamicType.DYNAMIC);
            } else {
                shape = 0;
                element = elementFactory.createSquare(new Position(0f, 5f));
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
