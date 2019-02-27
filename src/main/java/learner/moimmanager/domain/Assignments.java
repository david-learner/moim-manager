package learner.moimmanager.domain;

import java.util.ArrayList;
import java.util.List;

public class Assignments {
    private List<Assignment> assignments;

    public Assignments() {
        assignments = new ArrayList<>();
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
