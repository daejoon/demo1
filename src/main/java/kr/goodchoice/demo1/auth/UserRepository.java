package kr.goodchoice.demo1.auth;

import java.util.Arrays;

public class UserRepository {
    private User[] users = new User[]{
            new User("user", "password"),
    };

    public User findById(String userId) {
        return Arrays.stream(users)
                .filter(user -> user.getUserId().equals(userId))
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }
}
