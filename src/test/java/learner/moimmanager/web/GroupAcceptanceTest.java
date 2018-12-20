package learner.moimmanager.web;

import learner.moimmanager.support.test.AcceptanceTest;
import learner.moimmanager.support.test.HtmlFormDataBuilder;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.util.MultiValueMap;

import static learner.moimmanager.support.test.DummyData.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GroupAcceptanceTest extends AcceptanceTest {
    private static final Logger log = LoggerFactory.getLogger(GroupAcceptanceTest.class);

    private ResponseEntity<String> response;
    private HttpEntity<MultiValueMap<String, Object>> request;

    @Before
    public void setUp() {
        HttpEntity<MultiValueMap<String, Object>> requestUserData = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "황다윗")
                .addParameter("nickname", "소프트러너")
                .addParameter("email", "learner@soft.com")
                .addParameter("password", "password1234").build();

        template.postForEntity("/users", requestUserData, String.class);

        requestUserData = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "장요셉")
                .addParameter("nickname", "이시대의한사람")
                .addParameter("email", "jang@joseph.com")
                .addParameter("password", "password1234").build();

        template.postForEntity("/users", requestUserData, String.class);

        request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "트레바리")
                .addParameter("category", "독서")
                .addParameter("region", "부산")
                .addParameter("connect_type", "online").build();
    }

    @Test
    public void createForm() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.getForEntity("/groups/create", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void create() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@soft.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
    }

    @Test
    public void list() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@soft.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);

        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody().contains(DEFAULT_GROUP.getName()), is(true));
    }

    @Test
    public void join() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);

        authTemplate = template.withBasicAuth("jang@joseph.com", "password1234");
        response = authTemplate.getForEntity("/groups/1/join", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void home() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        authTemplate.postForEntity("/groups", request, String.class);
        ResponseEntity<String> response = template.getForEntity("/groups/1", String.class);
        log.debug("reponse body : {}", response.getBody());
        assertThat(response.getBody().contains("부경나비"), is(true));
    }

    @Test
    public void accept() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));

        authTemplate = template.withBasicAuth("jang@joseph.com", "password1234");
        response = authTemplate.getForEntity("/groups/1/join", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        // 모임장 로그인 상태에서 수락 요청 가능
        authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.getForEntity("/groups/1/joinWaitingMembers/1/accept", String.class);
        assertThat(response.getBody().contains("모임장"), is(true));
    }

    @Ignore
    @Test
    public void reject() {
        log.debug("email : " + DEFAULT_DB_MEMBER.getPassword() + "  password : " + DEFAULT_DB_MEMBER.getPassword());
        TestRestTemplate authTemplate = template.withBasicAuth(DEFAULT_DB_MEMBER.getEmail(), DEFAULT_PASSWORD);
        ResponseEntity<String> response = authTemplate.getForEntity("/groups/1/join", String.class);
        assertTrue(response.getBody().contains(DEFAULT_DB_MEMBER.getName()));

        // 멤버의 아이디로 reject 기준을 잡는다, 그런데 테스트에서 문제가 발생하는 이유는 DummyData는 id값을 들고 있지 않기 때문에.
        authTemplate = template.withBasicAuth(DEFAULT_DB_LEADER.getEmail(), DEFAULT_PASSWORD);
        response = authTemplate.getForEntity("/groups/1/joinWaitingMembers/" + DEFAULT_DB_MEMBER.getId() + "/reject", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertFalse(response.getBody().contains(DEFAULT_DB_MEMBER.getName()));
    }
}
