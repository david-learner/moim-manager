package learner.moimmanager.web;

import learner.moimmanager.domain.Member;
import learner.moimmanager.dto.LoginMemberDto;
import learner.moimmanager.dto.MemberDto;
import learner.moimmanager.security.LoginUser;
import learner.moimmanager.service.MemberService;
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
public class MemberController {
    private static String SESSION_LOGIN_MEMBER_KEY = "loginMember";
    private static final Logger log = LoggerFactory.getLogger(MemberController.class);

    @Resource(name = "memberService")
    private MemberService memberService;

    @PostMapping()
    public String signUp(MemberDto memberDto) {
        log.debug("sign up : {}", memberDto.toString());
        memberService.create(memberDto);
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
    public String login(LoginMemberDto loginMemberDto, HttpSession session) {
        log.debug("loginMemberDto : {}", loginMemberDto.toString());
        Member member = memberService.login(loginMemberDto);
        session.setAttribute(SESSION_LOGIN_MEMBER_KEY, member);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(SESSION_LOGIN_MEMBER_KEY);
        return "redirect:/";
    }

    @GetMapping("/{id}/form")
    public String updateForm(@LoginUser Member member, @PathVariable Long id) {
        return "member/updateForm";
    }
}
