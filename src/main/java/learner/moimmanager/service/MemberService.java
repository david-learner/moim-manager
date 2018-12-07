package learner.moimmanager.service;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.Member;
import learner.moimmanager.dto.LoginMemberDto;
import learner.moimmanager.dto.MemberDto;
import learner.moimmanager.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MemberService {
    private static final Logger log = LoggerFactory.getLogger(MemberService.class);

    @Autowired
    private MemberRepository memberRepository;

    public void create(MemberDto memberDto) {
        log.debug("memberDto : {}", memberDto.toString());
        memberRepository.save(memberDto.toUser());
    }

    public Member login(LoginMemberDto loginMemberDto) {
        // todo 아이디비밀번호 불일치 exception
        return memberRepository.findByEmail(loginMemberDto.getEmail()).filter(u -> u.matches(loginMemberDto)).orElseThrow(IllegalArgumentException::new);
    }

    public void openGroup(Member leader, Group opendGroup) {
        leader.addOpendGroup(opendGroup);
        memberRepository.save(leader);
    }

    public Member getOne(Long id) {
        return memberRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public void save(Member member) {
        memberRepository.save(member);
    }
}
