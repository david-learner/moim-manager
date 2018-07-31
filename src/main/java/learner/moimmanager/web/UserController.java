package learner.moimmanager.web;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;
import learner.moimmanager.security.LoginUser;
import learner.moimmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
    private static String SESSION_LOGIN_USER_KEY = "loginUser";
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping()
    public String signUp(UserDto userDto) {
        log.debug("sign up : {}", userDto.toString());
        userService.create(userDto);
        return "redirect:/";
    }

    @GetMapping("/form")
    public String signUpForm() {
        return "/user/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "/user/signin";
    }

    @PostMapping("/login")
    public String login(LoginUserDto loginUserDto, HttpSession session) {
        log.debug("loginUserDto : {}", loginUserDto.toString());
        User user = userService.login(loginUserDto);
        session.setAttribute(SESSION_LOGIN_USER_KEY, user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(SESSION_LOGIN_USER_KEY);
        return "redirect:/";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@LoginUser User user, @PathVariable Long id) {
        return "user/updateForm";
    }
}
