package learner.moimmanager.service;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.Member;
import learner.moimmanager.repository.GroupRepository;
import learner.moimmanager.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupService {

    private static final Logger log =  LoggerFactory.getLogger(GroupService.class);

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    @Resource(name = "memberService")
    private MemberService memberService;

    @Resource(name = "memberRepository")
    private MemberRepository memberRepository;

    public void create(Member opener, GroupProperties properties) {
        log.debug("GroupProperties : {}", properties.toString());
        Group openedGroup = new Group(opener, properties);
        // TODO 제약조건 위반하지 않게 cascade 설정 다시하기, 현재는 save가 먼저 되어야 함
        openedGroup = groupRepository.save(openedGroup);
        memberService.openGroup(opener, openedGroup);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findOne(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(NullPointerException::new);
    }

    public void join(Member loginMember, Long groupId) {
        groupRepository.findById(groupId).map(group -> {
            group.joinRequestBy(loginMember);
            groupRepository.save(group);
            return group;
        }).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void accept(Member acceptor, Long groupId, Long memberId) {
        Group group = groupRepository.findById(groupId).orElseThrow(NullPointerException::new);
        if(!group.matchLeader(acceptor)) {
            throw new IllegalArgumentException("Only leader can accept join request");
        }
        Member dbMember = memberRepository.findById(memberId).orElseThrow(NullPointerException::new);
        group.accept(dbMember);
        dbMember.addJoinedGroup(group);
        memberRepository.save(dbMember);
        groupRepository.save(group);
    }
}
