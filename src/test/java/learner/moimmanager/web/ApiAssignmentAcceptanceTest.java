package learner.moimmanager.web;

import learner.moimmanager.domain.Assignment;
import learner.moimmanager.domain.Assignments;
import learner.moimmanager.support.test.AcceptanceTest;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiAssignmentAcceptanceTest extends AcceptanceTest {
    @Test
    public void createAssignment() {
        Assignment assignment = new Assignment(
                1L
                , "실행이 답이다 3주차 과제"
                , "워크북을 작성하세요"
                , LocalDateTime.of(2019, 2, 25, 8, 00)
                , LocalDateTime.of(2019, 2, 27, 15, 00));

        ResponseEntity<Assignment> responseAssignment =
                template.postForEntity("/api/assignments/create", assignment, Assignment.class);
        assertThat(responseAssignment.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    public void getList() {
        // groupId로 해당 그룹에서 생성된 과제 목록 불러오기
        // Wrapper class인 Assignments가 없을 때, List<Assignment>를 리턴받아 테스트하는 방법 찾기
        Long groupId = 1L;
        Assignments assignments =
                template.getForObject("/api/assignments/groups/" + groupId, Assignments.class);
        assertThat(assignments.getAssignments().size()).isEqualTo(0);
    }
}
