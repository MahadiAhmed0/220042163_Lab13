package model;

import java.util.*;

public class Customer {
    private final String userId;
    private final String password;
    private CustomerProfile profile;
    private final List<BookingRecord> bookings;

    public Customer(String userId, CustomerProfile profile, String password) {
        this.userId = userId;
        this.profile = profile;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public void addBooking(Flight flight, int numberOfTickets) {
        Optional<BookingRecord> existingBooking = findBooking(flight);
        if (existingBooking.isPresent()) {
            existingBooking.get().addTickets(numberOfTickets);
        } else {
            bookings.add(new BookingRecord(flight, numberOfTickets));
        }
    }

    public Optional<BookingRecord> findBooking(Flight flight) {
        return bookings.stream()
                .filter(b -> b.getFlight().equals(flight))
                .findFirst();
    }

    public void updateProfile(CustomerProfile newProfile) {
        this.profile = newProfile;
    }

    // Getters
    public String getUserID() { return userId; }
    public CustomerProfile getProfile() { return profile; }
    public String getPassword() { return password; }
    public List<BookingRecord> getBookings() { 
        return Collections.unmodifiableList(bookings); 
    }
}