public class RolesAndPermissions extends User {
    private final AuthenticationStrategy adminAuthStrategy;
    private final AuthenticationStrategy passengerAuthStrategy;

    public RolesAndPermissions() {
        this.adminAuthStrategy = new AdminAuthenticationStrategy(adminUserNameAndPassword);
        this.passengerAuthStrategy = new PassengerAuthenticationStrategy(Customer.customerCollection);
    }

    public int isPrivilegedUserOrNot(String username, String password) {
        AuthenticationResult result = adminAuthStrategy.authenticate(username, password);
        return result.isAuthenticated() ? Integer.parseInt(result.getUserId()) : -1;
    }

    public String isPassengerRegistered(String email, String password) {
        AuthenticationResult result = passengerAuthStrategy.authenticate(email, password);
        return result.isAuthenticated() ? "1-" + result.getUserId() : "0";
    }
}
