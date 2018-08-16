package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    @Test
    public void create() {
        Group group = new Group("부경나비", DummyData.DEFAULT_DB_USER);
        assertThat(group.getId(), is(0L));
        assertThat(group.toString().contains("부경나비"),is(true));
    }

    @Test
    public void addUser() {
        Group group = new Group("인터나비", DummyData.DEFAULT_DB_USER);
        User user = new User("정재욱", "재우기", "password", "jung@jaewook.com");
        group.addUser(user);
        assertThat(group.getUsers().toString().contains("정재욱"), is(true));
    }


}
