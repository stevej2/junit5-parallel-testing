import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ;
import static org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE;

@Execution(ExecutionMode.CONCURRENT)
public class ResourceLockExample
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
    @ResourceLock(value = "EGGPLANT_LICENCE_1")
    public void testTag1() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("testTag1");
    }

    @Test
    @ResourceLock(value = "EGGPLANT_LICENCE_1")
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

    @Test
    // READ tests can run in parallel, but NOT with a READ_WRITE test
    @ResourceLock(value = "DATABASE_1", mode = READ)
    public void exampleRead() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("exampleRead");
    }

    @Test
    // READ tests can run in parallel, but NOT with a READ_WRITE test
    @ResourceLock(value = "DATABASE_1", mode = READ)
    public void exampleRead2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("exampleRead2");
    }

    @Test
    // READ_WRITE tests enforce exclusive access to the resource
    @ResourceLock(value = "DATABASE_1", mode = READ_WRITE)
    public void exampleWrite() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("exampleWrite");
    }
}
