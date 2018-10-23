package learner.moimmanager.domain;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Groups {

    @OneToMany
    private List<Group> groups;

    public Groups() {
        groups = new ArrayList<>();
    }

    public void add(Group group) {
        groups.add(group);
    }
}
