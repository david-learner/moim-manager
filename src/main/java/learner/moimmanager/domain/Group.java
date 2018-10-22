package learner.moimmanager.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Group {

    @Id @GeneratedValue
    private long id;

    @Size(min = 1, max = 15)
    @Column(length = 15)
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User leader;

    @ManyToMany
    private List<User> users = new ArrayList<>();

    private String sort_primary;

    private String sort_secondary;

    private String region;

    private String connect_type;

    //Constructor

    public Group() {
    }

    //Getter-Setter

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getLeader() {
        return leader;
    }

    public String getConnect_type() {
        return connect_type;
    }

    public void setConnect_type(String connect_type) {
        this.connect_type = connect_type;
    }

    public String getName() {
        return name;
    }

    public Group setName(String name) {
        this.name = name;
        return this;
    }

    public String getSort_primary() {
        return sort_primary;
    }

    public void setSort_primary(String sort_primary) {
        this.sort_primary = sort_primary;
    }

    public String getSort_secondary() {
        return sort_secondary;
    }

    public void setSort_secondary(String sort_secondary) {
        this.sort_secondary = sort_secondary;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    //Custom

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader=" + leader +
                ", users=" + Arrays.toString(users.toArray()) +
                '}';
    }

    public void addMember(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public Group madeBy(User leader) {
        this.leader = leader;
        return this;
    }
}
