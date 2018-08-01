package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.security.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
@RunWith(PowerMockRunner.class)
@PrepareForTest(Encryption.class)
public class UserTest {
    @Test
    public void create() {
        User guest = new User();
        assertNull(guest.getName());
    }

    @Test
    public void match() {
//        LoginUserDto loginUserDto = new LoginUserDto("hard@learner.com", "password1234");
//        assertThat(DEFAULT_DB_USER.matches(loginUserDto), is(true));

        LoginUserDto loginUserDto = new LoginUserDto("hard@learner.com", "password1234");

        PowerMockito.mockStatic(Encryption.class);
        BDDMockito.given(Encryption.matches(loginUserDto.getPassword(), DEFAULT_DB_USER.getPassword())).willReturn(true);

        assertTrue(DEFAULT_DB_USER.matches(loginUserDto));
    }
}
