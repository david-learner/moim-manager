package learner.moimmanager.service;

import learner.moimmanager.domain.User;
import learner.moimmanager.repository.UserRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static learner.moimmanager.support.test.DummyData.DEFAULT_DB_LEADER;
import static learner.moimmanager.support.test.DummyData.DEFAULT_GROUP;
import static learner.moimmanager.support.test.DummyData.DEFAULT_LOGIN_USER_DTO;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder encoder;

    @Ignore
    @Test
    public void login() {
        when(userRepository.findByEmail(DEFAULT_LOGIN_USER_DTO.getEmail())).thenReturn(Optional.of(DEFAULT_DB_LEADER));
        // Encryption내 encoder가 static이라서 Junit으로 테스트 불가능 -> PowerMock으로대체
//        when(encoder.matches(DEFAULT_DB_LEADER.getPassword(), DEFAULT_DB_LEADER.getPassword())).thenReturn(true);
        User dbUser = userService.login(DEFAULT_LOGIN_USER_DTO);
        assertThat(DEFAULT_DB_LEADER, is(dbUser));

    }

    @Test
    public void openGroup() {
        when(userRepository.save(DEFAULT_DB_LEADER)).thenReturn(DEFAULT_DB_LEADER);

        userService.openGroup(DEFAULT_DB_LEADER, DEFAULT_GROUP);
    }
}
