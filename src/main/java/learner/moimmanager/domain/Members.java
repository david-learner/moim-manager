package learner.moimmanager.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Embeddable
public class Members {

    @OneToMany
    private Set<Member> members;

    public Members() {
    }

    public Members(Member leader) {
        members = new HashSet<>(leader.getMemberCapacity());
    }

    public void add(Member member) {
        if (members.contains(member)) {
            throw new IllegalArgumentException("Already join is requested");
        }
        members.add(member);
    }

    public int size() {
        return members.size();
    }

    public Set<Member> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "Members{" +
                "members=" + members +
                '}';
    }

    public List<String> getMembersName() {
        return members.stream().map(Member::getName).collect(Collectors.toList());
    }

    public void remove(Member member) {
        members.remove(member);
    }
}
