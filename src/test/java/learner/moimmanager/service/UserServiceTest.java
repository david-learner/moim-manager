package learner.moimmanager.service;

import learner.moimmanager.domain.User;
import learner.moimmanager.repository.UserRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_USER;
import static learner.moimmanager.support.test.DummyData.DEFAULT_LOGIN_USER_DTO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Test
    public void login() {
        UserRepository userRepository = mock(UserRepository.class);
        when(userRepository.findByEmail(DEFAULT_LOGIN_USER_DTO.getEmail())).thenReturn(Optional.of(DEFAULT_DB_USER));

        User dbUser = userRepository.findByEmail(DEFAULT_LOGIN_USER_DTO.getEmail()).get();
        assertThat(dbUser.matches(DEFAULT_LOGIN_USER_DTO), is(true));
    }
}
