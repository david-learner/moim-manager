package learner.moimmanager.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encyption {
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    private Encyption() {
    }

    public static String encode(String rawPassword) {
        return encoder.encode(rawPassword);
    }
}
