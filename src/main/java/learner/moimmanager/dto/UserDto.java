package learner.moimmanager.dto;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.User;
import learner.moimmanager.security.Encryption;

public class UserDto {

    private String name;
    private String nickname;
    private String password;
    private String email;

    public UserDto() {
    }

    public UserDto(String name, String nickname, String password, String email) {
        this.name = name;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
    }

    public User toUser() {
        return new User(name, nickname, Encryption.encode(password), email, Grade.NORMAL);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
