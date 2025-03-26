public class SessionManager {
    private static SessionManager instance;
    private String currentUserId;
    private String currentUsername;
    private UserType userType;

    public enum UserType {
        ADMIN, ROOT_ADMIN, PASSENGER, NONE
    }

    private SessionManager() {
        this.userType = UserType.NONE;
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession(String userId, String username, UserType type) {
        this.currentUserId = userId;
        this.currentUsername = username;
        this.userType = type;
    }

    public void endSession() {
        this.currentUserId = null;
        this.currentUsername = null;
        this.userType = UserType.NONE;
    }

    public boolean isLoggedIn() {
        return currentUserId != null;
    }

    public UserType getUserType() {
        return userType;
    }
}