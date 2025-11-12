import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HRCalculatorTest {
    @Test
    public void testValidMaxHR() {
        var result = HRCalculator.calculateMaxHR(25);
        assertEquals(195, result);
    }

    @Test
    public void testInvalidMinHR_ageTooHigh() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(500));
    }

    @Test
    public void testInvalidMinHR_ageTooLow() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.calculateMaxHR(-1));
    }

    @Test
    public void testValidHeartZone1() {
        var result = HRCalculator.getWorkoutZone(25, 98);
        assertEquals("Moderate Activity (Maintenance/warm up)", result);
    }
    @Test
    public void testValidHeartZone2() {
        var result = HRCalculator.getWorkoutZone(50, 105);
        assertEquals("Weight Control (Fitness training / fat burning)", result);
    }
    @Test
    public void testValidHeartZone3() {
        var result = HRCalculator.getWorkoutZone(35, 130);
        assertEquals("Aerobic (Cardio / endurance training)", result);
    }
    @Test
    public void testValidHeartZone4() {
        var result = HRCalculator.getWorkoutZone(65, 124);
        assertEquals("Anaerobic (Hardcore Training)", result);
    }
    @Test
    public void testValidHeartZone5() {
        var result = HRCalculator.getWorkoutZone(30, 190);
        assertEquals("VO2 Max (Maximum effort)", result);
    }

    @Test
    public void testValueOutsideOfWorkoutZone() {
        var result = HRCalculator.getWorkoutZone(20, 80);
        assertEquals("Not in workout zone", result);
    }

    @Test
    public void testInvalidBPM_InputHeartZone() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(20, -100));
    }

    @Test
    public void testInvalidAge_InputHeartZone() {
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(-4, 120));
    }
    @Test
    public void testZeroIntensity(){
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(0, 0));
    }
    @Test
    public void testIntensityOver1(){
        assertThrows(IllegalArgumentException.class,
                () -> HRCalculator.getWorkoutZone(90,140 ));
    }
}
