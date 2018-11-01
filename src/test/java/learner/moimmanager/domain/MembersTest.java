package learner.moimmanager.domain;

import static learner.moimmanager.support.test.DummyData.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MembersTest {
    @Test
    public void canCreate() {
        Members members = new Members(DEFAULT_DB_LEADER);
    }

    @Test
    public void add() {
        Members members = new Members(DEFAULT_DB_LEADER);
        User user = new User("황러너", "learner", "password", "learner@learn.er", Grade.NORMAL);
        assertThat(members.size(), is(0));

        members.add(user);
        assertThat(members.size(), is(1));
    }

    @Test
    public void size() {
        Members members = new Members(DEFAULT_DB_LEADER);
        assertThat(members.size(), is(0));
    }

    @Test
    public void getMembersNames() {
        Members members = new Members(DEFAULT_DB_LEADER);
        User user1 = new User("남상코", "sangco", "password", "sangco@nam.com", Grade.NORMAL);
        User user2 = new User("고링크", "link", "password", "link@go.com", Grade.NORMAL);
        members.add(user1);
        members.add(user2);

        List<String> names = members.getMembersName();
        assertThat(names.size(), is(2));
        assertThat(names.contains("남상코"), is(true));
        assertThat(names.contains("고링크"), is(true));
    }

    @Test
    public void delete() {
        Members members = new Members(DEFAULT_DB_LEADER);
        members.add(DEFAULT_DB_MEMBER);
        assertThat(members.size(), is(1));

        members.remove(DEFAULT_DB_MEMBER);
        assertThat(members.size(), is(0));
    }
}
