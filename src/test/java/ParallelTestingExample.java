import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;
import java.time.Instant;

// Comment out the following line to run tests sequentially
@Execution(ExecutionMode.CONCURRENT)
public class ParallelTestingExample
{
    static Instant startTime;

    @BeforeAll
    public static void startTime() {
        startTime = Instant.now();
    }

    @AfterAll
    public static void endTime() {
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(startTime, end);
        System.out.println(timeElapsed.toSeconds() + " seconds elapsed");
    }

    @Test
    public void testTag1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("testTag1");
    }

    @Test
    public void testTag2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("testTag2");
    }

    @Test
    public void testTag3() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("testTag3");
    }

    @Test
    public void testTag4() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("testTag4");
    }
}
