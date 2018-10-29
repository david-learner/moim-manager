package learner.moimmanager.web;

import learner.moimmanager.domain.User;
import learner.moimmanager.security.LoginUser;
import learner.moimmanager.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    public GroupService groupService;

    @Autowired
    public HomeController(GroupService group) {
        groupService = group;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "index";
    }
}
