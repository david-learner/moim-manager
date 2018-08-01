package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.UserDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HttpSessionUtilsTest {
    private static String SESSION_LOGIN_USER_KEY = "loginUser";

    @Test
    public void isLoginUser() {
        HttpSession httpSession = new MockHttpSession();
        httpSession.setAttribute(SESSION_LOGIN_USER_KEY, DEFAULT_DB_USER);
        assertThat(HttpSessionUtils.isLoginUser(httpSession), is(true));
    }

    @Test
    public void getUserFromSession() {
        NativeWebRequest request = mock(NativeWebRequest.class);
        request.setAttribute(SESSION_LOGIN_USER_KEY, DEFAULT_DB_USER, RequestAttributes.SCOPE_SESSION);

        Optional<User> maybeUser = Optional.ofNullable(DEFAULT_DB_USER);
        when(HttpSessionUtils.getUserFromSession(request)).thenReturn(maybeUser);
        assertThat(maybeUser.get().getName(), is("황러너"));
    }
}
