package learner.moimmanager.web;

import learner.moimmanager.domain.User;
import learner.moimmanager.security.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
