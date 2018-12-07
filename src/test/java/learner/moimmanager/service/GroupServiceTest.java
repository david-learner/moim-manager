package learner.moimmanager.service;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import learner.moimmanager.repository.GroupRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class GroupServiceTest {

    @InjectMocks
    private GroupService groupService;

    @Mock
    private GroupRepository groupRepository;

    @Test
    public void findOne() {
        when(groupRepository.findById(1L)).thenReturn(Optional.of(DEFAULT_GROUP));
        assertNotNull(groupService.findOne(1L));
    }

    @Ignore
    @Test
    public void join() {
        groupService.join(DEFAULT_DB_LEADER, 1L);
    }
}
