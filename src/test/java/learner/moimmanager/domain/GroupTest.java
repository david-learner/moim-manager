package learner.moimmanager.domain;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    private Group group;

    @Before
    public void setUp() {
        group = new Group(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES);
    }

    @Test
    public void create() {
        assertThat(group.getName(), is("부경나비"));
    }

    @Test
    public void addUser() {
        assertThat(group.getMemberCount(), is(0));
        group.addMember(DEFAULT_DB_MEMBER);
        assertThat(group.getMemberCount(), is(1));
    }

    @Test
    public void joinRequestBy() {
        group.joinRequestBy(DEFAULT_DB_MEMBER);
        assertThat(group.getJoinWaitingMemberCount(), is(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void joinRequestBySameUser() {
        group.joinRequestBy(DEFAULT_DB_MEMBER);
        group.joinRequestBy(DEFAULT_DB_MEMBER);
    }

    @Test
    public void accept() {
        group.joinRequestBy(DEFAULT_DB_MEMBER);
        group.accept(DEFAULT_DB_MEMBER);
        assertThat(group.getJoinWaitingMemberCount(), is(0));
        assertThat(group.getMemberCount(), is(1));
    }
}
