package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginMemberDto;
import learner.moimmanager.security.Encryption;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "moim_member")
public class Member {
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
    @AssociationOverride(name = "groups", joinTable = @JoinTable(name = "moim_member_opened_groups"))
    private Groups openedGroups;

    @Embedded
    @AssociationOverride(name = "groups", joinTable = @JoinTable(name = "moim_member_joined_groups"))
    private Groups joinedGroups;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Member() {
    }

    public Member(String name, String nickName, String password, String email, Grade grade) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.grade = grade;
        openedGroups = new Groups(grade.getOpenCapacity());
        joinedGroups = new Groups(grade.getJoinCapacity());
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

    public boolean matches(LoginMemberDto loginMemberDto) {
        if (!this.email.equals(loginMemberDto.getEmail())) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("id가 일치하지 않습니다.");
        }

        if (!Encryption.matches(loginMemberDto.getPassword(), password)) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("pw가 일치하지 않습니다.");
        }
        return true;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Groups addOpendGroup(Group openedGroup) {
        openedGroups.add(openedGroup);
        return openedGroups;
    }

    public Groups addJoinedGroup(Group joinedGroup) {
        joinedGroups.add(joinedGroup);
        return joinedGroups;
    }

    public int getMemberCapacity() {
        return grade.getMemberCapacity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) &&
                Objects.equals(name, member.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public boolean canOpenGroup() {
        System.out.println("size : " + openedGroups.size() + " grade capacity" + grade.getOpenCapacity());
        return openedGroups.size() < grade.getOpenCapacity();
    }
}
