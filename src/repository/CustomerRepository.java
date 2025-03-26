package repository;

import model.Customer;
import java.util.*;

public class CustomerRepository {
    private static final List<Customer> customers = new ArrayList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public void remove(Customer customer) {
        customers.remove(customer);
    }

    public Optional<Customer> findById(String id) {
        return customers.stream()
                .filter(c -> c.getUserID().equals(id))
                .findFirst();
    }

    public boolean existsByEmail(String email) {
        return customers.stream()
                .anyMatch(c -> c.getProfile().getEmail().equals(email));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}