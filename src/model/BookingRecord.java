package model;

public class BookingRecord {
    private Flight flight;
    private int numberOfTickets;

    public BookingRecord(Flight flight, int numberOfTickets) {
        this.flight = flight;
        this.numberOfTickets = numberOfTickets;
    }

    public Flight getFlight() { return flight; }
    public int getNumberOfTickets() { return numberOfTickets; }
    public void addTickets(int tickets) {
        this.numberOfTickets += tickets;
    }
}