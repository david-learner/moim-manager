package learner.moimmanager.service;

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
}
