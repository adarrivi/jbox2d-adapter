package org.adarrivi.physicsframework.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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
