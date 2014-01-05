package org.adarrivi.physicsframework;

import javax.swing.JFrame;

import org.adarrivi.physicsframework.model.CandyFactory;
import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.model.force.LinearForce;

/**
 * Class that will step the simulation and trigger the graphical refresh. It
 * also creates circles and squares every few steps
 * 
 * @author adarrivi
 * 
 */
class StepCommand implements Runnable {

    private static final float FORCE_MAGNITUDE = 150f;
    private static final int STEPS_BETWEEN_CREATIONS = 50;
    private int skipBallCreation;
    private boolean createBall;
    private CandyFactory elementFactory;
    private LinearForce initialForce;
    private Position startPosition = new Position(0f, 5f);
    private SandBox sandBox;
    private JFrame viewFrame;

    StepCommand(CandyFactory candyFactory, ForceFactory forceFactory, SandBox sandBox, JFrame viewFrame) {
        this.elementFactory = candyFactory;
        this.sandBox = sandBox;
        this.viewFrame = viewFrame;
        this.initialForce = forceFactory.createLinearForce(FORCE_MAGNITUDE, 1);
    }

    @Override
    public void run() {
        if (skipBallCreation % STEPS_BETWEEN_CREATIONS == 0) {
            if (createBall) {
                Element element = elementFactory.createCandyBall(startPosition);
                initialForce.applyOn(element);
            } else {
                Element element = elementFactory.createCandySquare(startPosition);
                initialForce.applyOn(element);
            }
            createBall = !createBall;
        }
        skipBallCreation++;
        sandBox.step();
        viewFrame.repaint();
    }
}
