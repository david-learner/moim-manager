package learner.moimmanager.dto;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class LoginMemberDtoTest {
    @Test
    public void create() {
        LoginMemberDto loginMemberDto = new LoginMemberDto();
        assertNull(loginMemberDto.getEmail());
    }
}
