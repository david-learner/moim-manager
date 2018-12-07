package learner.moimmanager.dto;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class MemberDtoTest {

    @Test
    public void create() {
        MemberDto memberDto = new MemberDto();
        assertNull(memberDto.getName());
    }
}
