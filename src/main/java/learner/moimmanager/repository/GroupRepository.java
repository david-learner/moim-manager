package learner.moimmanager.repository;

import learner.moimmanager.domain.Group;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GroupRepository extends CrudRepository<Group, Long> {
    @Override
    List<Group> findAll();
}
