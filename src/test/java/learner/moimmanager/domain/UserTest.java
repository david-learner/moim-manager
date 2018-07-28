package learner.moimmanager.domain;

import org.junit.Test;

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
        assertThat(DEFAULT_DB_USER.matches(DEFAULT_LOGIN_USER_DTO), is(true));
    }
}
