package learner.moimmanager.security;

import learner.moimmanager.domain.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
//        User user = HttpSessionUtils.getUserFromSession(webRequest);
//        if (user != null) {
//            return user;
//        }
//
//        throw new IllegalStateException("You need login");
        return HttpSessionUtils.getUserFromSession(webRequest).orElseThrow(IllegalArgumentException::new);
    }
}
