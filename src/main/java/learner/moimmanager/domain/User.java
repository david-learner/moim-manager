package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.security.Encryption;

import javax.persistence.*;

@Entity
@Table(name = "moim_member")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String nickName;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 60, nullable = false, unique = true)
    private String email;

    @Embedded
    private Groups openedGroups;

    @Embedded
    private Groups joinedGroups;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public User() {
    }

    public User(String name, String nickName, String password, String email, Grade grade) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.grade = grade;
        openedGroups = new Groups(grade.getCapacity());
        joinedGroups = new Groups(grade.getCapacity());
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

    public Long getId() {
        return id;
    }

    public Grade getGrade() {
        return grade;
    }

    public boolean matches(LoginUserDto loginUserDto) {
        if (!this.email.equals(loginUserDto.getEmail())) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("id가 일치하지 않습니다.");
        }

        if (!Encryption.matches(loginUserDto.getPassword(), password)) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("pw가 일치하지 않습니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // 왜 opendGroups를 리턴하는가? 현재 가입된 모임의 개수를 DB를 거치지 않고 바로 알 수 있고, 테스트 용이성
    public Groups addOpendGroup(Group openedGroup) {
        openedGroups.add(openedGroup);
        return openedGroups;
    }

    public Groups addJoinedGroup(Group joinedGroup) {
        joinedGroups.add(joinedGroup);
        return joinedGroups;
    }
}
