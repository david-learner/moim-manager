package learner.moimmanager.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GradeTest {
    @Test
    public void getGroupOpenCapacity_NORMAL_GRADE() {
        assertThat(Grade.NORMAL.getOpenCapacity(), is(10));
    }

    @Test
    public void getGroupJoinCapacity_NORMAL_GRADE() {
        assertThat(Grade.NORMAL.getJoinCapacity(), is(5));
    }

    @Test
    public void getMemberCapacity_NORMAL_GRADE() {
        assertThat(Grade.NORMAL.getMemberCapacity(), is(10));
    }
}
