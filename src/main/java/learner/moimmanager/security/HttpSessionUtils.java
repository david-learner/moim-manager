package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    public static String SESSION_LOGIN_USER_KEY = "loginUser";

    public static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(SESSION_LOGIN_USER_KEY) != null;
    }

    public static User getUserFromSession(NativeWebRequest request) {
        return (User) request.getAttribute(SESSION_LOGIN_USER_KEY, WebRequest.SCOPE_SESSION);
    }
}
