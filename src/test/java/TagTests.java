import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class TagTests
{
    @Test
    public void testTag1()
    {
        System.out.println("testTag1");
    }

    @Test
    public void testTag2()
    {
        System.out.println("testTag2");
    }

    @Test
    public void testTag3()
    {
        System.out.println("testTag3");
    }

    @Test
    public void testTag4()
    {
        System.out.println("testTag4");
    }
}
