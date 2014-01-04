package org.adarrivi.physicsframework.executor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class RunnableCommandMs implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(RunnableCommandMs.class);
    private final AtomicInteger TIMES_EXECUTED = new AtomicInteger(0);

    private long milliseconds;

    RunnableCommandMs(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
            TIMES_EXECUTED.incrementAndGet();
        } catch (InterruptedException ex) {
            LOG.error("Runnable command unexpectedly interrupted: ", ex);
        }
    }

    public int getTimesExecuted() {
        return TIMES_EXECUTED.get();
    }

}
