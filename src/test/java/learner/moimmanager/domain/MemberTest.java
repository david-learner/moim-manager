package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginMemberDto;
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
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Encryption.class)
public class MemberTest {
    @Test
    public void create() {
        Member guest = new Member();
        assertNull(guest.getName());
    }

    @Test
    public void getMemberGrade() {
        Member normalMember = new Member("황태원", "learner", "password", "learner@learn.er", Grade.NORMAL);
        assertThat(normalMember.getGrade(), is(Grade.NORMAL));
    }

    @Test
    public void match() {
        PowerMockito.mockStatic(Encryption.class);

        LoginMemberDto loginMemberDto = new LoginMemberDto("learner@hard.com", "password1234");
        BDDMockito.given(Encryption.matches(loginMemberDto.getPassword(), DEFAULT_DB_LEADER.getPassword())).willReturn(true);
        assertTrue(DEFAULT_DB_LEADER.matches(loginMemberDto));
    }

    @Test
    public void addOpendGroup() {
        assertThat(DEFAULT_DB_LEADER.addOpendGroup(DEFAULT_GROUP).size(), is(1));
    }

    @Test
    public void getMemberCapacity() {
        assertThat(DEFAULT_DB_LEADER.getMemberCapacity(), is(10));
    }

    @Test
    public void canOpenGroup() {
        assertTrue(DEFAULT_DB_LEADER.canOpenGroup());
    }

    @Test
    public void cannotOpenGroup() {
        // Normal Member's opened group max size is 10
        for (int count = 0; count < 10; count++) {
            DEFAULT_DB_LEADER.addOpendGroup(new Group());
        }
        assertFalse(DEFAULT_DB_LEADER.canOpenGroup());
    }
}
