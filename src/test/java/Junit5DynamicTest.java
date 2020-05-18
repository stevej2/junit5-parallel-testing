import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.ThrowingConsumer;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;
import static org.junit.jupiter.api.DynamicTest.stream;

public class Junit5DynamicTest {

    static Instant startTime;

    void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

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

    @Execution(ExecutionMode.CONCURRENT)
    @TestFactory
    Stream<DynamicTest> streamTest() {

//        Integer array[] = { 1, 2, 3 };
//        Iterator<Integer> inputGenerator = Arrays.asList(array).iterator();

        List<Integer> range = IntStream.rangeClosed(1, 1000)
                .boxed().collect(Collectors.toList());

        Iterator<Integer> inputGenerator = range.iterator();

        // Display names
        Function<Integer, String> displayNameGenerator = (
                input) -> "Data input: " + input;

        // Test executor
        ThrowingConsumer<Integer> testExecutor = (input) -> {
            System.out.println("Executing test: " + input);
            sleep(10);
            assertTrue(true);
//            assertTrue(input % 2 == 0, input + " not an even number");
        };

        // Returns a stream of dynamic tests
        return stream(inputGenerator, displayNameGenerator, testExecutor);
    }

//    @TestFactory
//    Stream<DynamicTest> dynamicTestsFromIntStream() throws Exception {
//        return IntStream.iterate(1, n -> n + 1).limit(10)
//                .mapToObj(n -> DynamicTest.dynamicTest("test: " + n,
//                        () -> assertTrue(n % 2 == 0)));
//    }


}
