public class Hub {
    private final LoginDatabase loginDatabase = new LoginDatabase();
    private final MovieDatabase movieDatabase = new MovieDatabase();
    private UserCredentials userCredentials;

    public Hub() {

    }

    public LoginDatabase getLoginDatabase() {
        return loginDatabase;
    }

    public MovieDatabase getMovieDatabase() {
        return movieDatabase;
    }

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }


    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public UserCredentials registerUser(String username, String password, String role) {
        UserCredentials newUser = new UserCredentials(username, password, role);
        loginDatabase.addUser(newUser);
        return newUser;
    }
}
