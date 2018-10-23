package learner.moimmanager.domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GradeTest {
    @Test
    public void getGroupMemberCapacity() {
        assertThat(Grade.NORMAL.getCapacity(), is(10));
    }
}
