package learner.moimmanager.domain;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 15, nullable = false)
    private String name;

    @Column(length = 30, nullable = false)
    private String nickName;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(String name, String nickName, String password, String email) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
