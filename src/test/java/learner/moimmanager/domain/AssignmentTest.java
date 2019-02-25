package learner.moimmanager.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignmentTest {
    @Test
    public void build() {
        Assignment assignment = new Assignment.Builder().title("실행이 답이다 3주차 과제").build();
        assertThat(assignment).isNotNull();
    }
}
