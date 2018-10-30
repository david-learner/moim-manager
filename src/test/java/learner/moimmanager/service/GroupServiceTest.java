package learner.moimmanager.service;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import learner.moimmanager.domain.Group;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;

public class GroupServiceTest {

    @InjectMocks
    private GroupService groupService;

    @Test
    public void findOne() {
        when(groupService.create(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES)).thenReturn(DEFAULT_GROUP);
        groupService.create(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES);
        assertNotNull(groupService.findOne(1L));
    }

    @Ignore
    @Test
    public void join() {
        groupService.join(DEFAULT_DB_LEADER, 1L);
    }
}
