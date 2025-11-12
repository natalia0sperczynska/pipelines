import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class HRCalculatorTest {
    @Test
    public void testValidMaxHR(){
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }
}
