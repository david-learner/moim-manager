package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static learner.moimmanager.support.test.DummyData.DEFAULT_LOGIN_USER_DTO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void create() {
        User guest = new User();
        assertNull(guest.getName());
    }

    @Test
    public void match() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        LoginUserDto loginUserDto = new LoginUserDto("hard@learner.com", "password1234");
        assertThat(DEFAULT_DB_USER.matches(loginUserDto), is(true));
    }
}
