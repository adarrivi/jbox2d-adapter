package org.adarrivi.physicsframework;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.adarrivi.physicsframework.adapter.physics.Jbox2dPhysicsAdapter;
import org.adarrivi.physicsframework.adapter.view.panel.PhysicsViewFrame;
import org.adarrivi.physicsframework.model.element.ElementFactory;
import org.adarrivi.physicsframework.model.element.Position;
import org.adarrivi.physicsframework.model.element.SandBox;
import org.adarrivi.physicsframework.physic.adapter.PhysicsAdapter;

public class SwingAndJbox2dSim {

    private int skip;

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        new SwingAndJbox2dSim().start();
    }

    public SwingAndJbox2dSim() {

    }

    public void start() {
        PhysicsAdapter physicsAdapter = new Jbox2dPhysicsAdapter();
        PhysicsViewFrame frame = new PhysicsViewFrame(physicsAdapter);
        ElementFactory elementFactory = new ElementFactory(physicsAdapter);
        SandBox sandBox = elementFactory.createEarthSandBox();
        elementFactory.createRectangle(new Position(0f, 0f), 12f, 1f);

        while (true) {
            // TODO Create an executor for a steady fps rate
            long nanoTimeTaken = System.nanoTime();
            sandBox.step();
            if (skip % 50 == 0) {
                elementFactory.createCircle(new Position(0f + new Random().nextFloat(), 5f), 0.5f);
            }
            skip++;
            frame.repaint();
            nanoTimeTaken = System.nanoTime() - nanoTimeTaken;
            long nanosToSleep = TimeUnit.MILLISECONDS.toNanos(16) - nanoTimeTaken;
            long msToSleep = TimeUnit.NANOSECONDS.toMillis(nanosToSleep);
            if (msToSleep > 0) {
                try {
                    Thread.sleep(msToSleep);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
