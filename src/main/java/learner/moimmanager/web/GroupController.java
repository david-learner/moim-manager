package learner.moimmanager.web;

import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.Member;
import learner.moimmanager.security.LoginUser;
import learner.moimmanager.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("groups")
public class GroupController {
    private static final Logger log = LoggerFactory.getLogger(GroupController.class);

    @Resource(name = "groupService")
    private GroupService groupService;

    @GetMapping("create")
    public String createForm(@LoginUser Member loginMember) {
        return "/group/createForm";
    }

    @PostMapping
    public String create(@LoginUser Member member, GroupProperties properties) {
        groupService.create(member, properties);
        return "redirect:/";
    }

    @GetMapping("/{id}/join")
    public String join(@LoginUser Member loginMember, @PathVariable Long id) {
        groupService.join(loginMember, id);
        return "redirect:/groups/" + id;
    }

    @GetMapping("/{id}")
    public String home(@PathVariable Long id, Model model, HttpSession session) {
        model.addAttribute("group", groupService.findOne(id));
        return "/group/home";
    }

    @GetMapping("/{groupId}/joinWaitingMember/{memberId}/accept")
    public String accept(@LoginUser Member leader, @PathVariable Long groupId, @PathVariable Long memberId) {
        groupService.accept(leader, groupId, memberId);
        return "redirect:/groups/" + groupId;
    }

    @GetMapping("/{groupId}/joinWaitingMembers/{memberId}/reject")
    public String reject(@LoginUser Member leader, @PathVariable Long groupId, @PathVariable Long memberId) {
        groupService.reject(leader, groupId, memberId);
        return "redirect:/groups/" + groupId;
    }
}
