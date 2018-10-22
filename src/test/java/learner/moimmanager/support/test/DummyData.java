package learner.moimmanager.support.test;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;

public class DummyData {
    public final static UserDto DEFAULT_USER_DTO = new UserDto("황러너", "hardLearner", "password1234", "hard@learner.com");
    public final static User DEFAULT_DB_USER = new User("황러너", "hardLearner", "$2a$10$dfjoraNXdiAgcUsRp7sABO28xByV2EtjMUre2VGqUsLinHxw8Sfvi", "hard@learner.com", Grade.NORMAL);
    public final static LoginUserDto DEFAULT_LOGIN_USER_DTO = new LoginUserDto("hard@learner.com", "password1234");
    public final static GroupProperties DEFAULT_GROUP_PROPERTIES = new GroupProperties(DummyData.DEFAULT_DB_USER, "부경나비", "독서", "online", "부산");
}
