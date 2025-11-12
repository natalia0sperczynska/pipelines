public class HRCalculator {
    public static int calculateMaxHR(int age) {
        if (age > 120 || age < 0) {
            throw new IllegalArgumentException(
                    "Age out of bounds"
            );
        }
        return 220 - age;
    }

    public static String getWorkoutZone(int age, int bpm) {
        int MHR = calculateMaxHR(age);
        double intensity = (double) bpm / MHR;
        if (intensity >= 0.5 && intensity < 0.6) {
            return "Moderate Activity (Maintenance/warm up)";

        } else if (intensity >= 0.6 && intensity < 0.7) {
            return "Weight Control (Fitness training / fat burning)";

        } else if (intensity >= 0.7 && intensity < 0.8) {
            return "Aerobic (Cardio / endurance training)";

        } else if (intensity >= 0.8 && intensity < 0.9) {
            return "Anaerobic (Hardcore Training)";

        } else if (intensity >= 0.9 && intensity <= 1) {
            return "VO2 Max (Maximum effort)";

        } else if (intensity > 0 && intensity < 0.5) {
            return "Not in workout zone";

        } else {
            throw new IllegalArgumentException(
                    "Invalid input - values out of bounds"
            );
        }

    }
}
