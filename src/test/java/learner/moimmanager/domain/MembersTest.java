package learner.moimmanager.domain;

import org.junit.Test;

public class MembersTest {
    @Test
    public void canCreate() {
        Members members = new Members();
        Members limited_members = new Members(10);
    }
}
