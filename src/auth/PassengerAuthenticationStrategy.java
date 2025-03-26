public class PassengerAuthenticationStrategy implements AuthenticationStrategy {
    private final List<Customer> customerCollection;

    public PassengerAuthenticationStrategy(List<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @Override
    public AuthenticationResult authenticate(String email, String password) {
        for (Customer customer : customerCollection) {
            if (email.equals(customer.getEmail()) && 
                password.equals(customer.getPassword())) {
                return new AuthenticationResult(true, customer.getUserID(), UserType.PASSENGER);
            }
        }
        return new AuthenticationResult(false, null, UserType.PASSENGER);
    }
}