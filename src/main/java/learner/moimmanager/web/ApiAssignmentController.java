package learner.moimmanager.web;

import learner.moimmanager.domain.Assignment;
import learner.moimmanager.service.AssignmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/assignments")
public class ApiAssignmentController {
    private static final Logger log = LoggerFactory.getLogger(ApiAssignmentController.class);

    @Autowired
    AssignmentService assignmentService;

    @PostMapping("/create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        URI createUrl = linkTo(methodOn(ApiAssignmentController.class).createAssignment(null)).slash("{id}").toUri();
        assignment.setId(1L);
        return ResponseEntity.created(createUrl).body(assignment);
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<List<Assignment>> getAssginmentList(@PathVariable Long groupId) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/api/assignments/group" + groupId))
                .body(assignmentService.getAssignments(groupId));
    }
    // JPA만 슬라이스테스트 하는 방법
    // return되어야 할 assignments가 안나와서.
}
