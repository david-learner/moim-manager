package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

public class GroupsTest {
    @Test
    public void canCreate() {
        Groups groups = new Groups();
    }

    @Test
    public void add() {
        Groups groups = new Groups();
        groups.add(DummyData.DEFAULT_GROUP);
    }
}
