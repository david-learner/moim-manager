package learner.moimmanager.domain;

import javax.persistence.*;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User leader;

    private Members members;

    private GroupProperties properties;

    //Constructor
    public Group(User opener, GroupProperties properties) {
        leader = opener;
        members = new Members(opener);
        this.properties = properties;
    }

    //Getter-Setter
    public String getName() {
        return properties.getName();
    }

    public int getMemberCount() {
        return members.size();
    }

    //Custom

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", leader=" + leader +
                ", members=" + members +
                ", properties=" + properties +
                '}';
    }

    public void addMember(User user) {
        if (members == null) {
            members = new Members(user);
        }
        members.add(user);
    }
}
