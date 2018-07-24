package learner.moimmanager.dto;

import learner.moimmanager.domain.User;

public class UserDto {

    private String name;
    private String nickName;
    private String password;
    private String email;

    public UserDto() {
    }

    public UserDto(String name, String nickName, String password, String email) {
        this.name = name;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public User toUser() {
        return new User(name, nickName, password, email);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
