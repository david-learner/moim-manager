package learner.moimmanager.security;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BcrytTest {
    @Test
    public void matches() {
        String rawPassword = "password1234";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(rawPassword);
        assertThat(encoder.matches(rawPassword, "$2a$10$dz3H1lzrsiWVLfYjHzevWescgmz7OzVtWEfdDchorkT9F00uEnXgC"), is(true));
    }
}
