package learner.moimmanager.service;

import learner.moimmanager.domain.Grade;
import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GroupService {

    private static final Logger log =  LoggerFactory.getLogger(GroupService.class);

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    @Resource(name = "userService")
    private UserService userService;

    public Group create(User leader, GroupProperties properties) {
        log.debug("GroupProperties : {}", properties.toString());
        Group openedGroup = new Group(leader, properties);
        // TODO 제약조건 위반하지 않게 cascade 설정 다시하기, 현재는 save가 먼저 되어야 함
        groupRepository.save(openedGroup);
        userService.openGroup(leader, openedGroup);
        return null;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }
}
