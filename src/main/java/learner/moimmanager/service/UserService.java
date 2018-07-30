package learner.moimmanager.service;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;
import learner.moimmanager.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    private static final Logger log =  LoggerFactory.getLogger(UserService.class);

    @Resource(name = "userRepository")
    UserRepository userRepository;

    public void create(UserDto userDto) {
        log.debug("userDto : {}", userDto.toString());
        userRepository.save(userDto.toUser());
    }

    public User login(LoginUserDto loginUserDto) {
        User dbUser = userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(NullPointerException::new);
        if(!dbUser.matches(loginUserDto)) {
            // todo 아이디비밀번호 불일치
            throw new IllegalArgumentException("User not matches");
        }
        return dbUser;
    }
}
