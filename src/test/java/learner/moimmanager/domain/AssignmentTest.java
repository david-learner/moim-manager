package learner.moimmanager.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssignmentTest {
    @Test
    public void create() {
        Assignment assignment = new Assignment();
    }

    @Test
    public void build() {
        Assignment assignment = new Assignment.Builder().build();
        assertThat(assignment).isNotNull();
    }
}
