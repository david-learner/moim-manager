package learner.moimmanager.web;

import learner.moimmanager.dto.UserDto;
import learner.moimmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Resource(name = "userService")
    UserService userService;

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
}
