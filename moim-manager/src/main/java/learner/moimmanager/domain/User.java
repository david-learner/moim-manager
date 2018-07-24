package learner.moimmanager.domain;

public class User {

    private String name;
    private String nickName;
    private String password;
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
