public class FlightRepository {
    private static final List<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    public Optional<Flight> findByFlightNumber(String flightNumber) {
        return flights.stream()
                .filter(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findFirst();
    }

    public boolean deleteFlight(String flightNumber) {
        return flights.removeIf(f -> f.getFlightNumber().equalsIgnoreCase(flightNumber));
    }
}