package learner.moimmanager.domain;

import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
public class Members {

    @OneToMany
    private List<User> members;

    public Members(User leader) {
        members = new ArrayList<>(leader.getGrade().getGroupMemberCapacity());
    }

    public void add(User user) {
        members.add(user);
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
