package learner.moimmanager.dto;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class UserDtoTest {

    @Test
    public void create() {
        UserDto userDto = new UserDto();
        assertNull(userDto.getName());
    }

}
