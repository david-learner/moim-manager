package learner.moimmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Group {

    @Id
    @GeneratedValue
    private long id;

    @Size(min = 1, max = 15)
    @Column(length = 15)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User leader;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    public Group() {
    }

    public Group(String name, User leader) {
        this.name = name;
        this.leader = leader;
    }

    public long getId() {
        return id;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader=" + leader +
                ", users=" + Arrays.toString(users.toArray()) +
                '}';
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }
}
