package learner.moimmanager.repository;

import learner.moimmanager.domain.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long> {
    Optional<Member> findById(Long id);

    Optional<Member> findByEmail(String email);
}
