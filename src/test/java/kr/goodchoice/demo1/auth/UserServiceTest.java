package kr.goodchoice.demo1.auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class UserServiceTest {

    private UserRepository userRepository;
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userRepository = new UserRepository();
        userService = new UserService(userRepository);
    }

    @Test
    public void 로그인_파라미터가_존재하지_않는다면_IllegalArgumentException이_발생한다() throws Exception {
        // given

        // when
        Throwable thown = catchThrowable(() -> {
            userService.login("user", null);
        });

        // then
        assertThat(thown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 로그인_아이디가_존재하지않는다면_UserNotFoundException_발생한다() throws Exception {
        // given

        // when
        Throwable thown = catchThrowable(() -> {
            userService.login("notfounduser", "password");
        });

        // then
        assertThat(thown).isInstanceOf(UserNotFoundException.class);
    }

    @Test
    public void 비밀번호가_일치하지_않는다면_PasswordNonMatchExceptionn_발생한() throws Exception {
        // given

        // when
        Throwable thown = catchThrowable(() -> {
            userService.login("user", "wrongpassword");
        });

        // then
        assertThat(thown).isInstanceOf(PasswordNonMatchException.class);
    }

    @Test
    public void 로그인에_성공하면_User객체를_반환한다() throws Exception {
        // given
        String userId = "user";
        String password = "password";

        // when
        User user = userService.login(userId, password);

        // then
        assertThat(user).isInstanceOf(User.class);
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getPassword()).isEqualTo(password);
    }

}
