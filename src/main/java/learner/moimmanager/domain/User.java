package learner.moimmanager.domain;

import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.security.Encryption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    //    @Column(columnDefinition = "BINARY(60)", nullable = false)
    @Column(length = 60, nullable = false)
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

    public Long getId() {
        return id;
    }

    public boolean matches(LoginUserDto loginUserDto) {
        if (!this.email.equals(loginUserDto.getEmail())) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("id가 일치하지 않습니다.");
        }

        // todo Bcryt 사용하여 pw 비교하기
//        if (Encryption.matches(loginUserDto.getPassword(), password)) {
        if (!Encryption.matches(loginUserDto.getPassword(), password)) {
            // todo id, pw 일치하지 않는 예외 만들기
            throw new IllegalArgumentException("pw가 일치하지 않습니다.");
        }
        return true;
    }
}
