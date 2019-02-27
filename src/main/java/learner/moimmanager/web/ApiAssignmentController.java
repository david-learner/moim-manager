package learner.moimmanager.web;

import learner.moimmanager.domain.Assignment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping(value = "/api/assignment")
public class ApiAssignmentController {
    private static final Logger log = LoggerFactory.getLogger(ApiAssignmentController.class);

    @PostMapping("/create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        URI createUrl = linkTo(methodOn(ApiAssignmentController.class).createAssignment(null)).slash("{id}").toUri();
        assignment.setId(1L);
        return ResponseEntity.created(createUrl).body(assignment);
    }
}
