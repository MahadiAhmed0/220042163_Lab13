public class AdminAuthenticationStrategy implements AuthenticationStrategy {
    private final String[][] adminUserNameAndPassword;

    public AdminAuthenticationStrategy(String[][] adminUserNameAndPassword) {
        this.adminUserNameAndPassword = adminUserNameAndPassword;
    }

    @Override
    public AuthenticationResult authenticate(String username, String password) {
        for (int i = 0; i < adminUserNameAndPassword.length; i++) {
            if (username.equals(adminUserNameAndPassword[i][0]) && 
                password.equals(adminUserNameAndPassword[i][1])) {
                return new AuthenticationResult(true, String.valueOf(i), UserType.ADMIN);
            }
        }
        return new AuthenticationResult(false, null, UserType.ADMIN);
    }
}