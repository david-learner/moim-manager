package learner.moimmanager.service;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.User;
import learner.moimmanager.repository.GroupRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GroupService {

    @Resource(name = "groupRepository")
    private GroupRepository groupRepository;

    public void create(User leader, Group group) {
        groupRepository.save(group.madeBy(leader));
    }
}
