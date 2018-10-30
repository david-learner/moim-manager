package learner.moimmanager.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable
public class Members {

    @OneToMany
    private Set<User> members;

    public Members() {
    }

    public Members(User leader) {
        members = new HashSet<>(leader.getCapacity());
    }

    public void add(User member) {
        members.add(member);
    }

    public int size() {
        return members.size();
    }

    @Override
    public String toString() {
        return "Members{" +
                "members=" + members +
                '}';
    }
}
