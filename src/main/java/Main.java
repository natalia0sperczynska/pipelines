public class Main {
    public static void main(String[] args){
        int age = 28;
        int bpm = 160;
        int maxHR = HRCalculator.calculateMaxHR(age);
        String workoutZone = HRCalculator.getWorkoutZone(age, bpm);
        System.out.printf("%nage = %d, BPM = %d-> maximum heart rate = %d, workout zone = %s%n",
                age, bpm, maxHR, workoutZone);
    }
}
