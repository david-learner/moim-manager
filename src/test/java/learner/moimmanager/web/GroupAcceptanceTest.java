package learner.moimmanager.web;

import learner.moimmanager.domain.Group;
import learner.moimmanager.support.test.AcceptanceTest;
import learner.moimmanager.support.test.DummyData;
import learner.moimmanager.support.test.HtmlFormDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;

import javax.xml.ws.Response;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class GroupAcceptanceTest extends AcceptanceTest {
    private static final Logger log = LoggerFactory.getLogger(GroupAcceptanceTest.class);

    private ResponseEntity<String> response;

    @Before
    public void setUp() {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "황다윗")
                .addParameter("nickname", "소프트러너")
                .addParameter("email", "learner@soft.com")
                .addParameter("password", "password1234").build();

        template.postForEntity("/users", request, String.class);

        request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "장요셉")
                .addParameter("nickname", "이시대의한사람")
                .addParameter("email", "jang@joseph.com")
                .addParameter("password", "password1234").build();

        template.postForEntity("/users", request, String.class);
    }

    @Test
    public void createForm() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.getForEntity("/groups/create", String.class);
        assertThat(response.getStatusCode() ,is(HttpStatus.OK));
    }

    @Test
    public void create() {
        // 멀티밸류맵으로 넘기기, 객체로 넘기려면 불필요한 생성자가 있어야 한다.
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "부경나비")
                .addParameter("category", "독서")
                .addParameter("region", "부산")
                .addParameter("connect_type", "online").build();

        TestRestTemplate authTemplate = template.withBasicAuth("learner@soft.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);
        assertThat(response.getStatusCode(),is(HttpStatus.FOUND));
    }

    @Test
    public void list() {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "부경나비")
                .addParameter("category", "독서")
                .addParameter("region", "부산")
                .addParameter("connect_type", "online").build();

        TestRestTemplate authTemplate = template.withBasicAuth("learner@soft.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);

        ResponseEntity<String> response = template.getForEntity("/", String.class);
        assertThat(response.getBody().contains(DummyData.DEFAULT_GROUP.getName()),is(true));
    }

    @Test
    public void join() {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "부경나비")
                .addParameter("category", "독서")
                .addParameter("region", "부산")
                .addParameter("connect_type", "online").build();

        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        response = authTemplate.postForEntity("/groups", request, String.class);

        authTemplate = template.withBasicAuth("jang@joseph.com", "password1234");
        response = authTemplate.getForEntity("/groups/1/join", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void home() {
        ResponseEntity<String> response = template.getForEntity("/groups/1", String.class);
        assertThat(response.getBody().contains("부경나비"), is(true));
    }
}
