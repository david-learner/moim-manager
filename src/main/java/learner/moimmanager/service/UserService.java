package learner.moimmanager.service;

import learner.moimmanager.domain.User;
import learner.moimmanager.dto.UserDto;
import learner.moimmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {

    @Resource(name = "userRepository")
    UserRepository userRepository;

    public void create(UserDto userDto) {
        userRepository.save(userDto.toUser());
    }

    public User login(UserDto userDto) {
        return userRepository.findByEmail(userDto.getEmail()).orElseThrow(NullPointerException::new);
        // 로그인 구현중, dto로 사용자 정보 넘겨받아서 db에서 조회해와서 비교하기 중
    }
}
