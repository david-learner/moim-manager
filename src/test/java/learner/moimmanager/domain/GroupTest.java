package learner.moimmanager.domain;

import org.junit.Test;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupTest {

    @Test
    public void create() {
        Group group = new Group(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES);
        assertThat(group.getName(), is("부경나비"));
    }

    @Test
    public void addUser() {
        // TODO DummyData.group 으로 전환하기
        Group group = new Group(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES);
        User user = new User("정재욱", "재욱쓰", "password", "jung@jaewook.com", Grade.NORMAL);

        assertThat(group.getMemberCount(), is(0));
        group.addMember(user);
        assertThat(group.getMemberCount(), is(1));
    }

    @Test
    public void joinRequestBy() {
        DEFAULT_GROUP.joinRequestBy(DEFAULT_DB_MEMBER);
        assertThat(DEFAULT_GROUP.getJoinWaitingMemberCount(), is(1));
    }

    @Test
    public void accept() {
        DEFAULT_GROUP.joinRequestBy(DEFAULT_DB_MEMBER);
        DEFAULT_GROUP.accept(DEFAULT_DB_MEMBER);
        assertThat(DEFAULT_GROUP.getJoinWaitingMemberCount(), is(0));
        assertThat(DEFAULT_GROUP.getMemberCount(), is(1));

    }
}
