package learner.moimmanager.service;

import learner.moimmanager.domain.Assignment;
import learner.moimmanager.repository.AssignmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public class AssignmentServiceTest {
    @Autowired
    AssignmentRepository assignmentRepository;

    @Test
    public void getAssignments() {
        Assignment assignment = new Assignment(
                1L
                , "과제1 - WAS 조사"
                , "WAS 종류를 조사하시오"
                , LocalDateTime.of(2019, 02, 27, 10, 01, 00)
                , LocalDateTime.of(2019, 02, 28, 11, 11, 00));

        List<Assignment> assignments = assignmentRepository.findAllById(1L);
        assertThat(assignments.size()).isEqualTo(0);

        assignmentRepository.save(assignment);
        assignments = assignmentRepository.findAllById(1L);
        assertThat(assignments.size()).isEqualTo(1);
    }
}
