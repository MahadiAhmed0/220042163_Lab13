public interface AuthenticationStrategy {
    AuthenticationResult authenticate(String identifier, String password);
}