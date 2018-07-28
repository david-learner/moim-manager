package learner.moimmanager.dto;

import learner.moimmanager.domain.User;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserDtoTest {

    @Test
    public void create() {
        UserDto userDto = new UserDto();
        assertNull(userDto.getName());
    }

    @Test
    public void toUser_encrypt() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = DEFAULT_USER_DTO.toUser();
        assertThat(encoder.matches(DEFAULT_LOGIN_USER_DTO.getPassword(), user.getPassword()),is(true));
    }
}
