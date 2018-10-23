package learner.moimmanager.web;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.security.LoginUser;
import learner.moimmanager.service.GroupService;
import learner.moimmanager.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("groups")
public class GroupController {
    private static final Logger log =  LoggerFactory.getLogger(GroupController.class);

    @Resource(name = "groupService")
    private GroupService groupService;

    @Resource(name = "userService")
    private UserService userService;

    @GetMapping
    public String createForm() {
        return "/group/groupCreateForm";
    }

    @PostMapping
    public String create(@LoginUser User user, GroupProperties properties) {
        groupService.create(user, properties);
        return "redirect:/";
    }
}
