package learner.moimmanager.domain;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;

public class GroupPropertiesTest {
    @Test
    public void setUp() {
        GroupProperties properties = new GroupProperties(DummyData.DEFAULT_DB_USER, "부경나비", "독서", "online", "부산");
    }
}
