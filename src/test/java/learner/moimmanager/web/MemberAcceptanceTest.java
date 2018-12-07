package learner.moimmanager.web;

import learner.moimmanager.support.test.HtmlFormDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class MemberAcceptanceTest {
    private static final Logger log =  LoggerFactory.getLogger(MemberAcceptanceTest.class);

    @Autowired
    TestRestTemplate template;

    @Test
    public void signUpForm() {
        ResponseEntity<String> response = template.getForEntity("/users/form", String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }

    @Test
    public void signUp() {
        HttpEntity<MultiValueMap<String, Object>> request = HtmlFormDataBuilder.urlEncodedForm()
                .addParameter("name", "남상코")
                .addParameter("nickname", "상코")
                .addParameter("email", "sangco@nam.com")
                .addParameter("password", "password1234").build();

        ResponseEntity<String> response = template.postForEntity("/users", request, String.class);
        assertThat(response.getStatusCode(), is(HttpStatus.FOUND));
    }

    @Test
    public void login() {
        TestRestTemplate authTemplate = template.withBasicAuth("learner@hard.com", "password1234");
        ResponseEntity<String> response = authTemplate.getForEntity("/", String.class);

        log.debug("response : {}", response.getBody());
        assertThat(response.getBody().contains("로그아웃"), is(true));
    }
}