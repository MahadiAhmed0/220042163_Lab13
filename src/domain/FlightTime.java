public class FlightTime {
    private final int hours;
    private final int minutes;

    public FlightTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
}