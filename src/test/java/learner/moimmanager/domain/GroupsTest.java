package learner.moimmanager.domain;

import org.junit.Test;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GroupsTest {
    @Test
    public void canCreate() {
        Groups groups = new Groups();
    }

    @Test
    public void add() {
        Groups groups = new Groups();
        groups.add(DEFAULT_GROUP);
    }

    @Test
    public void size() {
        Groups groups = new Groups();
        groups.add(DEFAULT_GROUP);
        assertThat(groups.size(), is(1));
    }
}
