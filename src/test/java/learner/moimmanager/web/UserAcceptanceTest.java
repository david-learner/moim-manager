package learner.moimmanager.web;

import learner.moimmanager.support.test.HtmlFormDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class UserAcceptanceTest {

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
                .addParameter("name", "홍길동")
                .addParameter("nickname", "하드러너")
                .addParameter("email", "hardlearner@gamil.com")
                .addParameter("password", "password").build();

        ResponseEntity<String> response = template.postForEntity("/users", request, String.class);
        assertThat(response.getStatusCode(),is(HttpStatus.FOUND));

    }
}

