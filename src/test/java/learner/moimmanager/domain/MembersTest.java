package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MembersTest {
    @Test
    public void canCreate() {
        Members members = new Members(DummyData.DEFAULT_DB_LEADER);
    }

    @Test
    public void add() {
        Members members = new Members(DummyData.DEFAULT_DB_LEADER);
        User user = new User("황러너", "learner", "password", "learner@learn.er", Grade.NORMAL);
        assertThat(members.size(), is(0));

        members.add(user);
        assertThat(members.size(), is(1));
    }

    @Test
    public void size() {
        Members members = new Members(DummyData.DEFAULT_DB_LEADER);
        assertThat(members.size(), is(0));
    }

    @Test
    public void getMembersNames() {
        Members members = new Members(DummyData.DEFAULT_DB_LEADER);
        User user1 = new User("황러너1", "learner1", "password", "learner1@learn.er", Grade.NORMAL);
        User user2 = new User("황러너2", "learner2", "password", "learner2@learn.er", Grade.NORMAL);
        members.add(user1);
        members.add(user2);

        List<String> names = members.getMembersName();
        assertThat(names.size(), is(2));
        assertThat(names.get(0), is("황러너1"));
        assertThat(names.get(1), is("황러너2"));
    }
}
