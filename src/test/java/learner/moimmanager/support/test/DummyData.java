package learner.moimmanager.support.test;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.Member;
import learner.moimmanager.dto.LoginMemberDto;
import learner.moimmanager.dto.MemberDto;

public class DummyData {
    public final static MemberDto DEFAULT_USER_DTO = new MemberDto("황러너", "하드러너", "password1234", "hard@learner.com");
    public final static Member DEFAULT_DB_LEADER = new Member("황러너", "하드러너", "$2a$10$dfjoraNXdiAgcUsRp7sABO28xByV2EtjMUre2VGqUsLinHxw8Sfvi", "learner@hard.com", Grade.NORMAL);
    public final static Member DEFAULT_DB_MEMBER = new Member("김다윗", "소프트러너", "$2a$10$dfjoraNXdiAgcUsRp7sABO28xByV2EtjMUre2VGqUsLinHxw8Sfvi", "learner2@hard.com", Grade.NORMAL);
    public final static String DEFAULT_PASSWORD = "password1234";
    public final static LoginMemberDto DEFAULT_LOGIN_USER_DTO = new LoginMemberDto("learner@hard.com", "password1234");
    public final static GroupProperties DEFAULT_GROUP_PROPERTIES = new GroupProperties("부경나비", "독서", "online", "부산");
    public final static Group DEFAULT_GROUP = new Group(DEFAULT_DB_LEADER, DEFAULT_GROUP_PROPERTIES);
}
