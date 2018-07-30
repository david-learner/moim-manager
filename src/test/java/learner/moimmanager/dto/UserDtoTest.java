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
}
