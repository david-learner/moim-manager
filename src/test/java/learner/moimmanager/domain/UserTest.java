package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class UserTest {

    @Test
    public void create() {
        User guest = new User();
        assertNull(guest.getName());
    }

    @Test
    public void match() {
        LoginUserDto loginUserDto = new LoginUserDto("hard@learner.com", "password1234");
        assertThat(DEFAULT_DB_USER.matches(loginUserDto), is(true));
    }
}
