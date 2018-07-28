package learner.moimmanager.support.test;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;

public class DummyData {
    public final static UserDto DEFAULT_USER_DTO = new UserDto("황러너", "hardLearner", "password1234", "hard@learner.com");
    public final static User DEFAULT_DB_USER = new User("황러너", "hardLearner", "password1234", "hard@learner.com");
    public final static LoginUserDto DEFAULT_LOGIN_USER_DTO = new LoginUserDto("hard@learner.com", "password1234");
}
