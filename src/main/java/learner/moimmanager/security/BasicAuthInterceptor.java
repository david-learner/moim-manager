package learner.moimmanager.security;

import learner.moimmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthInterceptor extends HandlerInterceptorAdapter {
    private static final Logger log =  LoggerFactory.getLogger(BasicAuthInterceptor.class);

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        log.debug("Authorization : {}", authorization);
        return true;
//        return super.preHandle(request, response, handler);
    }
}
