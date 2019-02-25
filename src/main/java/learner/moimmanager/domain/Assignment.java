package learner.moimmanager.domain;

import org.apache.tomcat.jni.Local;

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
    private int submittedCount;
    private Byte[] attachment;
    @Column(nullable = false)
    private LocalDateTime startdate;
    @Column(nullable = false)
    private LocalDateTime enddate;

    public static class Builder {
        private Long id;
        private Long writerId;
        private String title;
        private String content;
        private int submittedCount;
        private Byte[] attachment;
        private LocalDateTime startdate;
        private LocalDateTime enddate;

        public Builder builder() {
            return this;
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder writerId(Long val) {
            writerId = val;
            return this;
        }

        public Builder title(String val) {
            title = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public Builder submittedCount(int val) {
            submittedCount = val;
            return this;
        }

        public Builder attachment(Byte[] val) {
            attachment = val;
            return this;
        }

        public Builder startdate(LocalDateTime val) {
            startdate = val;
            return this;
        }

        public Builder enddate(LocalDateTime val) {
            enddate = val;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }

    public Assignment(Builder builder) {
        this.writerId = builder.writerId;
        this.title = builder.title;
        this.content = builder.content;
        this.submittedCount = builder.submittedCount;
        this.attachment = builder.attachment;
        this.startdate = builder.startdate;
        this.enddate = builder.enddate;
    }
}
