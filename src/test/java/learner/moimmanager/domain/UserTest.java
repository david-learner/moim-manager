package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.security.Encryption;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_LEADER;
import static learner.moimmanager.support.test.DummyData.DEFAULT_GROUP;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
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
    public void getMemberGrade() {
        User normalUser = new User("황태원", "learner", "password", "learner@learn.er", Grade.NORMAL);
        assertThat(normalUser.getGrade(), is(Grade.NORMAL));
    }

    @Test
    public void match() {
        PowerMockito.mockStatic(Encryption.class);

        LoginUserDto loginUserDto = new LoginUserDto("learner@hard.com", "password1234");
        BDDMockito.given(Encryption.matches(loginUserDto.getPassword(), DEFAULT_DB_LEADER.getPassword())).willReturn(true);
        assertTrue(DEFAULT_DB_LEADER.matches(loginUserDto));
    }

    @Test
    public void addOpendGroup() {
        assertThat(DEFAULT_DB_LEADER.addOpendGroup(DEFAULT_GROUP).size(), is(1));
    }

    @Test
    public void getCapacity() {
        assertThat(DEFAULT_DB_LEADER.getMemberCapacity(), is(10));
    }


}
