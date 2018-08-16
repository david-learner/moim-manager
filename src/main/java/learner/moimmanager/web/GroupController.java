package learner.moimmanager.web;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.User;
import learner.moimmanager.security.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("groups")
public class GroupController {
    private static final Logger log =  LoggerFactory.getLogger(GroupController.class);

    @GetMapping
    public String createForm() {
        return "/group/groupCreateForm";
    }

    @PostMapping
    public String create(@LoginUser User user, Group group) {
        return "redirect:/";
    }
}
