import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
public class TagTypeTests
{
    @Test
    public void testTagType1()
    {
        System.out.println("testTagType1");
    }

    @Test
    public void testTagType2()
    {
        System.out.println("testTagType2");

    }

    @Test
    public void testTagType3()
    {
        System.out.println("testTagType3");
    }

    @Test
    public void testTagType4()
    {
        System.out.println("testTagType4");
    }

    @Test
    public void testTagType5()
    {
        System.out.println("testTagType5");
    }

    @Test
    public void testTagType6()
    {
        System.out.println("testTagType6");
    }
}
