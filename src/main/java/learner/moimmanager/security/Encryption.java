package learner.moimmanager.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Encryption {
    private static final Logger log = LoggerFactory.getLogger(Encryption.class);
    private static PasswordEncoder encoder;

    @Autowired
    public Encryption(PasswordEncoder passwordEncoder) {
        encoder = passwordEncoder;
    }

    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        log.debug("rawPassword, encodedPassword : {} {}", rawPassword, encodedPassword);
        return encoder.matches(rawPassword, encodedPassword);
    }
}
