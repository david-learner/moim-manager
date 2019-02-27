package learner.moimmanager.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import learner.moimmanager.domain.Assignment;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApiAssignmentAcceptanceTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void createAssignment() throws Exception {
        Assignment assignment = new Assignment(
                1L
                , "실행이 답이다 3주차 과제"
                , "워크북을 작성하세요"
                , LocalDateTime.of(2019, 2, 25, 8, 00)
                , LocalDateTime.of(2019, 2, 27, 15, 00));

//        ResponseEntity<Assignment> responseAssignment = restTemplate.postForEntity("/api/assignment/create", assignment, Assignment.class);
//        assertThat(responseAssignment).isNotNull();

        mockMvc.perform(post("/api/assignment/create")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(assignment)))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
