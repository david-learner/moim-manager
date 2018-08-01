package learner.moimmanager.dto;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class LoginUserDtoTest {
    @Test
    public void create() {
        LoginUserDto loginUserDto = new LoginUserDto();
        assertNull(loginUserDto.getEmail());
    }
}
