package org.adarrivi.physicsframework.executor;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

public class SteadyExecutorTest {

    // input parameter
    private RunnableCommandMs runnableCommand;

    private SteadyExecutor victim;

    @Test
    public void executeNoFasterThan_FasterCommand_ExecutesAll() {
        givenRunnableCommandProcessingTimeMillis(10);
        givenSteadyExecutor();
        whenExecuteNoFasterThanHertz(10, 350);
        whenStop();
        thenRunnableCommandShouldBeExecutedTimes(4);
    }

    private void givenRunnableCommandProcessingTimeMillis(long processingTimeMs) {
        runnableCommand = new RunnableCommandMs(processingTimeMs);
    }

    private void givenSteadyExecutor() {
        victim = new SteadyExecutor(runnableCommand);
    }

    private void whenExecuteNoFasterThanHertz(double hertz, long waitMs) {
        victim.executeNoFasterThan(hertz);
        try {
            TimeUnit.MILLISECONDS.sleep(waitMs);
        } catch (InterruptedException e) {
            Assert.fail();
        }
    }

    private void thenRunnableCommandShouldBeExecutedTimes(int expectedTimes) {
        Assert.assertEquals(expectedTimes, runnableCommand.getTimesExecuted());
    }

    @Test
    public void executeNoFasterThan_SlowCommand() {
        givenRunnableCommandProcessingTimeMillis(200);
        givenSteadyExecutor();
        whenExecuteNoFasterThanHertz(10, 350);
        whenStop();
        thenRunnableCommandShouldBeExecutedTimes(1);
    }

    @Test
    public void executeNoFasterThan_NoWait_ExecutesZero() {
        givenRunnableCommandProcessingTimeMillis(10);
        givenSteadyExecutor();
        whenExecuteNoFasterThanHertz(10, 0);
        whenStop();
        thenRunnableCommandShouldBeExecutedTimes(0);
    }

    private void whenStop() {
        victim.stop();
    }

}
