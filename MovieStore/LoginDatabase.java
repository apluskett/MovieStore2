import java.util.ArrayList;
import java.util.List;
public class LoginDatabase
{
    private final List<UserCredentials> userCredentialsList;
    public LoginDatabase() {
        this.userCredentialsList = new ArrayList<>();
        // Initialize with some user credentials
        userCredentialsList.add(new UserCredentials("PowerTripManager", "CheckIt@100", "Manager"));
    }

    // Method to authenticate a user
    public UserCredentials authenticateUser(String username, String password) {
        for (UserCredentials credentials : userCredentialsList) {
            if (credentials.getUsername().equals(username) && credentials.getPassword().equals(password)) {
                return credentials; // Return the matching credentials
            }
        }
        return null; // or throw an exception if user not found
    }

    public void addUser(UserCredentials credentials) {
        userCredentialsList.add(credentials);
    }

    // Other methods like addUser, removeUser, etc.
}