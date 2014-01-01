package org.adarrivi.physics;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.adarrivi.physics.adapter.PhysicsAdapter;
import org.adarrivi.physics.adapter.impl.Jbox2dPhysicsAdapter;
import org.adarrivi.physics.model.element.ElementFactory;
import org.adarrivi.physics.model.element.Position;
import org.adarrivi.physics.model.element.SandBox;
import org.adarrivi.physics.view.PhysicsViewFrame;

public class SimWithJBox2d {

    private int skip;

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        new SimWithJBox2d().start();
    }

    public SimWithJBox2d() {

    }

    public void start() {
        PhysicsAdapter physicsAdapter = new Jbox2dPhysicsAdapter();
        PhysicsViewFrame frame = new PhysicsViewFrame(physicsAdapter);
        ElementFactory elementFactory = new ElementFactory(physicsAdapter);
        SandBox sandBox = elementFactory.createEarthSandBox();
        elementFactory.createRectangle(new Position(0f, 0f), 6f, 0.5f);

        while (true) {
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
