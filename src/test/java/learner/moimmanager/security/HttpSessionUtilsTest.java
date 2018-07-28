package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpSessionUtilsTest {
    private static String SESSION_LOGIN_USER_KEY = "loginUser";

    @Test
    public void isLoginUser() {
        UserDto userDto = new UserDto("황러너", "하드러너", "learner", "hard@learner.com");
        User user = userDto.toUser();
        HttpSession httpSession = new MockHttpSession();
        httpSession.setAttribute("loginUser", user);
        assertThat(HttpSessionUtils.isLoginUser(httpSession), is(true));
    }
}
