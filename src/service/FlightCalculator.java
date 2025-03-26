public class FlightCalculator {
    private static final double GROUND_SPEED = 450.0;

    public static FlightTime calculateFlightTime(double distanceInMiles) {
        double time = (distanceInMiles / GROUND_SPEED);
        int hours = (int) time;
        int minutes = (int) ((time - hours) * 60);
        minutes = roundToNearestFive(minutes);
        
        if (minutes >= 60) {
            hours++;
            minutes -= 60;
        }
        
        return new FlightTime(hours, minutes);
    }

    private static int roundToNearestFive(int minutes) {
        int modulus = minutes % 5;
        return modulus < 3 ? minutes - modulus : minutes + (5 - modulus);
    }
}