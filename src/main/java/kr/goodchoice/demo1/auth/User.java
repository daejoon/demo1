package kr.goodchoice.demo1.auth;

public class User {

    private final String password;
    private final String userId;

    public String getPassword() {
        return password;
    }

    public String getUserId() {
        return userId;
    }

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public boolean matchPassword(String password) {
        return this.password.equals(password);
    }
}
