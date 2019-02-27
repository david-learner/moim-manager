package learner.moimmanager.service;

import learner.moimmanager.domain.Assignment;
import learner.moimmanager.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignments(Long groupId) {
        return assignmentRepository.findAllById(groupId);
    }
}
