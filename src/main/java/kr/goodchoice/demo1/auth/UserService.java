package kr.goodchoice.demo1.auth;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String userId, String password) {
        if (userId == null || password == null) {
            throw new IllegalArgumentException();
        }

        User user = this.userRepository.findById(userId);


        if (!user.matchPassword(password)) {
            throw new PasswordNonMatchException();
        }
        return user;
    }
}
