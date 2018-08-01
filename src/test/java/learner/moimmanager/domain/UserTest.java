package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.security.Encryption;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
        PowerMockito.mockStatic(Encryption.class);

        LoginUserDto loginUserDto = new LoginUserDto("hard@learner.com", "password1234");
        BDDMockito.given(Encryption.matches(loginUserDto.getPassword(), DEFAULT_DB_USER.getPassword())).willReturn(true);
        assertTrue(DEFAULT_DB_USER.matches(loginUserDto));
    }
}
