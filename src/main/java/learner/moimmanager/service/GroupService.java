package learner.moimmanager.service;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.repository.GroupRepository;
import learner.moimmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private static final Logger log =  LoggerFactory.getLogger(GroupService.class);

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    public void create(User leader, GroupProperties properties) {
        log.debug("GroupProperties : {}", properties.toString());
        Group openedGroup = new Group(leader, properties);
        // TODO 제약조건 위반하지 않게 cascade 설정 다시하기, 현재는 save가 먼저 되어야 함
        openedGroup = groupRepository.save(openedGroup);
        userService.openGroup(leader, openedGroup);
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findOne(Long groupId) {
        return groupRepository.findById(groupId).orElseThrow(NullPointerException::new);
    }

    public void join(User loginUser, Long groupId) {
        groupRepository.findById(groupId).map(group -> {
            group.joinRequestBy(loginUser);
            groupRepository.save(group);
            return group;
        }).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void accept(Long groupId, Long memberId) {
//        groupRepository.findById(groupId).ifPresent( group -> {
//            User dbUser = userService.getOne(memberId);
//            group.accept(dbUser);
//            dbUser.addOpendGroup(group);
//            groupRepository.save(group);
//            userRepository.save(dbUser);
//        });
        Group group = groupRepository.findById(groupId).orElseThrow(NullPointerException::new);
        User dbUser = userRepository.findById(memberId).orElseThrow(NullPointerException::new);
        group.accept(dbUser);
        dbUser.addJoinedGroup(group);
        userRepository.save(dbUser);
        groupRepository.save(group);
    }
}
