package server.auth;

import java.util.Arrays;
import java.util.List;

public class BaseAuthService implements AuthService {

    private static class UserData {
        private String login;
        private String password;
        private String userName;

        public UserData(String login, String password, String userName) {
            this.login = login;
            this.password = password;
            this.userName = userName;
        }
    }

    private static List<UserData> userData = Arrays.asList(
            new UserData("login1", "pass1", "username1"),
            new UserData("login2", "pass2", "username2"),
            new UserData("login3", "pass3", "username3")
    );

    @Override
    public void start() {
        System.out.println("Сервис атентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    @Override
    public String getUserNameByLoginAndPass(String login, String password) {
        for (UserData user : userData) {
            if (user.login.equals(login) && user.password.equals(password)) {
                return user.userName;
            }
        }
        return null;
    }
}
