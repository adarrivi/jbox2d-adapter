package org.adarrivi.physics;

import java.util.concurrent.TimeUnit;

import org.adarrivi.physics.view.PhysicsViewFrame;
import org.jbox2d.common.Vec2;

public class SimWithJBox2d {

    private PhysicsViewFrame frame;
    private int skip;

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        Utils.createWorld();
        new SimWithJBox2d().start();
    }

    public SimWithJBox2d() {
        frame = new PhysicsViewFrame();
    }

    public void start() {
        Utils.createFloor();
        while (true) {
            long nanoTimeTaken = System.nanoTime();
            Utils.world.step(1 / 60f, 8, 3);
            if (skip % 50 == 0) {
                Utils.createCircle(new Vec2(0f, 5f));
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
