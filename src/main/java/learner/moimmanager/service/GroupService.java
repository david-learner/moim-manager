package learner.moimmanager.service;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.GroupProperties;
import learner.moimmanager.domain.User;
import learner.moimmanager.repository.GroupRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupService {

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    public void create(User leader, GroupProperties properties) {
        Group group = new Group(leader, properties);
        groupRepository.save(null);
    }
}
