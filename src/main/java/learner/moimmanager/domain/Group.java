package learner.moimmanager.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private User leader;

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
