package learner.moimmanager.repository;

import learner.moimmanager.support.test.DummyData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GroupRepositoryTest {

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findAll() {
        userRepository.save(DummyData.DEFAULT_DB_LEADER);
        groupRepository.save(DummyData.DEFAULT_GROUP);
        assertThat(groupRepository.findAll().size(), is(1));
    }
}
