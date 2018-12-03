package learner.moimmanager.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Groups {

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Group> groups;

    public Groups() {
        this(1);
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
