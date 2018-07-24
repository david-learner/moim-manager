package learner.moimmanager.domain;

import org.junit.Test;

import javax.validation.constraints.Null;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void create() {
        User guest = new User();
        assertNull(guest.getName());
    }
}
