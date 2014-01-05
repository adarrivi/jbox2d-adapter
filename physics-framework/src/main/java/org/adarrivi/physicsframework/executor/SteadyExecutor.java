package org.adarrivi.physicsframework.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executor that will run the given Runnable command not faster than the hertzs
 * indicated. Once stopped it cannot be reused
 * 
 * 
 * @author adarrivi
 * 
 */
public class SteadyExecutor {

    private ScheduledExecutorService singleThreadedExecutorService = Executors.newSingleThreadScheduledExecutor();
    private Runnable command;

    public SteadyExecutor(Runnable command) {
        this.command = command;
    }

    public void executeNoFasterThan(double hertz) {
        Double commandPeriod = 1 / hertz * TimeUnit.SECONDS.toNanos(1);
        singleThreadedExecutorService.scheduleAtFixedRate(command, 0, commandPeriod.longValue(), TimeUnit.NANOSECONDS);
    }

    public void stop() {
        singleThreadedExecutorService.shutdown();
    }
}
