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
        groups = new ArrayList<>(1);
    }

    public Groups(int capacity) {
        groups = new ArrayList<>(capacity);
    }

    public void add(Group group) {
        groups.add(group);
    }

    public int size() {
        return groups.size();
    }
}
