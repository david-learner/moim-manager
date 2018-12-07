package learner.moimmanager.security;

import learner.moimmanager.domain.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public class HttpSessionUtils {
    private static final Logger log =  LoggerFactory.getLogger(HttpSessionUtils.class);

    public static String SESSION_LOGIN_MEMBER_KEY = "loginMember";

    protected static boolean isLoginUser(HttpSession session) {
        return session.getAttribute(SESSION_LOGIN_MEMBER_KEY) != null;
    }

    protected static Optional<Member> getUserFromSession(NativeWebRequest request) {
        log.debug("session util : {}", request.getAttribute(SESSION_LOGIN_MEMBER_KEY, WebRequest.SCOPE_SESSION));
        return Optional.ofNullable(request.getAttribute(SESSION_LOGIN_MEMBER_KEY, WebRequest.SCOPE_SESSION)).map(Member.class::cast);
    }
}
