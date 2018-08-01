package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpSessionUtilsTest {
    private static String SESSION_LOGIN_USER_KEY = "loginUser";

    @Test
    public void isLoginUser() {
        UserDto userDto = new UserDto("황러너", "하드러너", "learner", "hard@learner.com");
        User user = userDto.toUser();
        HttpSession httpSession = new MockHttpSession();
        httpSession.setAttribute(SESSION_LOGIN_USER_KEY, user);
        assertThat(HttpSessionUtils.isLoginUser(httpSession), is(true));
    }

    @Test
    public void getUserFromSession() {
        UserDto userDto = new UserDto("황러너", "하드러너", "learner", "hard@learner.com");
        User user = userDto.toUser();
        NativeWebRequest request = mock(NativeWebRequest.class);
        request.setAttribute(SESSION_LOGIN_USER_KEY, user, RequestAttributes.SCOPE_SESSION);

        Optional<User> maybeUser = Optional.ofNullable(user);
        when(HttpSessionUtils.getUserFromSession(request)).thenReturn(maybeUser);
        assertThat(maybeUser.get(),is(user));
    }
}
