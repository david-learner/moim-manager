package learner.moimmanager.service;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.LoginUserDto;
import learner.moimmanager.dto.UserDto;
import learner.moimmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource(name = "userRepository")
    UserRepository userRepository;

    public void create(UserDto userDto) {
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
