package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class HttpSessionUtils {
    public static String SESSION_LOGIN_USER_KEY = "loginUser";

    protected static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(SESSION_LOGIN_USER_KEY) != null;
    }

    protected static Optional<User> getUserFromSession(NativeWebRequest request) {
        return Optional.ofNullable(request.getAttribute(SESSION_LOGIN_USER_KEY, WebRequest.SCOPE_SESSION)).map(User.class::cast);
    }
}
