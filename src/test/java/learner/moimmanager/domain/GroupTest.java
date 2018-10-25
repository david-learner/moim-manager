package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    @Test
    public void create() {
        Group group = new Group(DummyData.DEFAULT_DB_USER, DummyData.DEFAULT_GROUP_PROPERTIES);
        assertThat(group.getName(), is("부경나비"));
    }

    @Test
    public void addUser() {
        Group group = new Group(DummyData.DEFAULT_DB_USER, DummyData.DEFAULT_GROUP_PROPERTIES);
        User user = new User("정재욱", "재우기", "password", "jung@jaewook.com", Grade.NORMAL);

        assertThat(group.getMemberCount(), is(0));
        group.addMember(user);
        assertThat(group.getMemberCount(), is(1));
    }
}
