package learner.moimmanager.service;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.repository.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupService {

    private static final Logger log =  LoggerFactory.getLogger(GroupService.class);

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    public Group create(User leader, GroupProperties properties) {
        return groupRepository.save(new Group(leader, properties));
    }
}
