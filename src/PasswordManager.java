public class PasswordManager {
    private static final String PASSWORD = "Pranay@123";

    public static boolean validatePassword(String password) {
        return PASSWORD.equals(password);
    }
}