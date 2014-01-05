package org.adarrivi.physicsframework;

import javax.swing.JFrame;

import org.adarrivi.physicsframework.model.CandyFactory;
import org.adarrivi.physicsframework.model.element.Element;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.model.force.AngularForce;
import org.adarrivi.physicsframework.model.force.ForceFactory;
import org.adarrivi.physicsframework.model.force.LinearForce;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

/**
 * Class that will step the simulation and trigger the graphical refresh. It
 * also creates circles and squares every few steps
 * 
 * @author adarrivi
 * 
 */
class DoubleViewStepCommand implements Runnable {

    private static final int ANGULAR_FORCE = 100;
    private static final float CANDY_FORCE_MAGNITUDE = 600f;
    private static final float SQUARE_FORCE_MAGNITUDE = 800f;
    private static final int STEPS_BETWEEN_CREATIONS = 50;
    private int skipBallCreation;
    private boolean createCandyBall;
    private CandyFactory elementFactory;
    private PhysicsAdapter physicsAdapter;
    private LinearForce initialLinearForce;
    private AngularForce initialAngularForce;
    private Position startPosition = new Position(-6f, 5f);
    private SandBox sandBox;
    private JFrame viewFrame;

    DoubleViewStepCommand(PhysicsAdapter physicsAdapter, CandyFactory candyFactory, SandBox sandBox, JFrame viewFrame) {
        this.elementFactory = candyFactory;
        this.sandBox = sandBox;
        this.viewFrame = viewFrame;
        this.physicsAdapter = physicsAdapter;
        ForceFactory forceFactory = new ForceFactory();
        this.initialLinearForce = forceFactory.createLinearForce(SQUARE_FORCE_MAGNITUDE, 1);
        this.initialAngularForce = forceFactory.createAngularForce(ANGULAR_FORCE, true);
    }

    @Override
    public void run() {
        if (skipBallCreation % STEPS_BETWEEN_CREATIONS == 0) {
            if (createCandyBall) {
                createCandyBallWithImpulse();
            } else {
                createCandySquareWithImpluse();
            }
            createCandyBall = !createCandyBall;
        }
        skipBallCreation++;
        physicsAdapter.step(sandBox);
        viewFrame.repaint();
    }

    private void createCandyBallWithImpulse() {
        Element candySquare = elementFactory.createCandyBall(startPosition);
        physicsAdapter.createElement(candySquare);
        initialLinearForce.setMagnitude(CANDY_FORCE_MAGNITUDE);
        physicsAdapter.applyForce(initialLinearForce, candySquare);
        initialAngularForce.setClockwise(true);
        physicsAdapter.applyForce(initialAngularForce, candySquare);
    }

    private void createCandySquareWithImpluse() {
        Element candySquare = elementFactory.createCandySquare(startPosition);
        physicsAdapter.createElement(candySquare);
        initialLinearForce.setMagnitude(SQUARE_FORCE_MAGNITUDE);
        physicsAdapter.applyForce(initialLinearForce, candySquare);
        initialAngularForce.setClockwise(false);
        physicsAdapter.applyForce(initialAngularForce, candySquare);
    }
}
