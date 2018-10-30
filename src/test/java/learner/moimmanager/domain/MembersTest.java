package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

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
        User user = new User("황태원", "learner", "password", "learner@learn.er", Grade.NORMAL);
        assertThat(members.size(), is(0));

        members.add(user);
        assertThat(members.size(), is(1));
    }

    @Test
    public void size() {
        Members members = new Members(DummyData.DEFAULT_DB_LEADER);
        assertThat(members.size(), is(0));
    }
}
