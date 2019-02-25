package learner.moimmanager.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Long writerId;
    @Column(length = 30, nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    // TINYINT 1byte -128 ~ +127
    @Column(name = "submit", columnDefinition = "TINYINT")
    private int summitedCount;
    private byte[] attachment;
    @Column(nullable = false)
    private LocalDateTime start;
    @Column(nullable = false)
    private LocalDateTime end;

    public static class Builder {
        public Builder builder() {
            return this;
        }

        public Assignment build() {
            return new Assignment();
        }
    }
}
