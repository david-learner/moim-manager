package learner.moimmanager.security;

import learner.moimmanager.domain.User;

import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
    private static String SESSION_LOGIN_USER_KEY = "loginUser";

    public static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(SESSION_LOGIN_USER_KEY) != null;
    }
}
