package learner.moimmanager.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encryption {
    private static final Logger log =  LoggerFactory.getLogger(Encryption.class);
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private Encryption() {
    }

    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        log.debug("rawPassword, encodedPassword : {} {}", rawPassword, encodedPassword);
        return encoder.matches(rawPassword, encodedPassword);
    }
}
