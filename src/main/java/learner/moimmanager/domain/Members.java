package learner.moimmanager.domain;

import java.util.ArrayList;
import java.util.List;

public class Members {

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
