package learner.moimmanager.repository;

import learner.moimmanager.domain.Group;
import learner.moimmanager.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
