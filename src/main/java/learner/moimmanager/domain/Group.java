package learner.moimmanager.domain;

import javax.persistence.*;

@Entity
@Table(name = "moim_group")
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User leader;

    @Embedded
    private Members members;

    @Embedded
    private GroupProperties properties;

    public Group() {
    }

    public Group(User opener, GroupProperties properties) {
        leader = opener;
        members = new Members(opener);
        this.properties = properties;
    }

    public String getName() {
        return properties.getName();
    }

    public int getMemberCount() {
        return members.size();
    }

    public void addMember(User user) {
        if (members == null) {
            members = new Members(user);
        }
        members.add(user);
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", leader=" + leader +
                ", members=" + members +
                ", properties=" + properties +
                '}';
    }
}
