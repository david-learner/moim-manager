package learner.moimmanager.support.test;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;

public class DummyData {
    public final static UserDto DEFAULT_USER_DTO = new UserDto("황러너", "하드러너", "password1234", "hard@learner.com");
    public final static User DEFAULT_DB_USER = new User("황러너", "하드러너", "$2a$10$dfjoraNXdiAgcUsRp7sABO28xByV2EtjMUre2VGqUsLinHxw8Sfvi", "learner@hard.com", Grade.NORMAL);
    public final static LoginUserDto DEFAULT_LOGIN_USER_DTO = new LoginUserDto("learner@hard.com", "password1234");
    public final static GroupProperties DEFAULT_GROUP_PROPERTIES = new GroupProperties("부경나비", "독서", "online", "부산");
    public final static Group DEFAULT_GROUP = new Group(DEFAULT_DB_USER, DEFAULT_GROUP_PROPERTIES);
}
