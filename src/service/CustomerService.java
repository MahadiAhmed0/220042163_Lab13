package service;

import model.Customer;
import model.CustomerProfile;
import repository.CustomerRepository;
import util.IdGenerator;

public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerDisplayService displayService;

    public CustomerService() {
        this.repository = new CustomerRepository();
        this.displayService = new CustomerDisplayService();
    }

    public Customer createCustomer(String name, String email, String password, 
                                 String phone, String address, int age) {
        if (repository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }

        CustomerProfile profile = new CustomerProfile(name, email, phone, address, age);
        String userId = IdGenerator.generateId();
        Customer customer = new Customer(userId, profile, password);
        repository.add(customer);
        return customer;
    }

    public void updateCustomer(String id, CustomerProfile newProfile) {
        repository.findById(id).ifPresent(customer -> 
            customer.updateProfile(newProfile));
    }

    public void deleteCustomer(String id) {
        repository.findById(id).ifPresent(repository::remove);
    }
}