package learner.moimmanager.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log =  LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public String signUp(@RequestBody String name,@RequestBody String nickname,@RequestBody String email,@RequestBody String password) {
        log.debug("sign up : {}, {}, {}, {}", name, nickname, email, password);
        return "redirect:/";
    }

    @GetMapping("/form")
    public String signUpForm() {
        return "/user/signup";
    }
}
