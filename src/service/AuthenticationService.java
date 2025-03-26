public class AuthenticationService {
    private static final int MAX_ADMINS = 10;
    private String[][] adminCredentials = new String[MAX_ADMINS][2];
    private int adminCount = 1;

    public AuthenticationService() {
        // Initialize default admin
        adminCredentials[0][0] = "root";
        adminCredentials[0][1] = "root";
    }

    public boolean registerAdmin(String username, String password) {
        if (adminCount >= MAX_ADMINS) {
            return false;
        }
        adminCredentials[adminCount][0] = username;
        adminCredentials[adminCount][1] = password;
        adminCount++;
        return true;
    }

    public int validateAdminLogin(String username, String password) {
        for (int i = 0; i < adminCount; i++) {
            if (adminCredentials[i][0].equals(username) && 
                adminCredentials[i][1].equals(password)) {
                return i == 0 ? 0 : 1; // 0 for root, 1 for other admins
            }
        }
        return -1;
    }

    public boolean isUsernameAvailable(String username) {
        for (int i = 0; i < adminCount; i++) {
            if (adminCredentials[i][0].equals(username)) {
                return false;
            }
        }
        return true;
    }
}