package learner.moimmanager.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;

@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Assignment() {
    }

    public Assignment(Long writerId, String title, String content, LocalDateTime startdate, LocalDateTime enddate) {
        this.writerId = writerId;
        this.title = title;
        this.content = content;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWriterId(Long writerId) {
        this.writerId = writerId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSubmittedCount(int submittedCount) {
        this.submittedCount = submittedCount;
    }

    public void setAttachment(Byte[] attachment) {
        this.attachment = attachment;
    }

    public void setStartdate(LocalDateTime startdate) {
        this.startdate = startdate;
    }

    public void setEnddate(LocalDateTime enddate) {
        this.enddate = enddate;
    }

    public Long getId() {
        return id;
    }

    public Long getWriterId() {
        return writerId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getSubmittedCount() {
        return submittedCount;
    }

    public Byte[] getAttachment() {
        return attachment;
    }

    public LocalDateTime getStartdate() {
        return startdate;
    }

    public LocalDateTime getEnddate() {
        return enddate;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", writerId=" + writerId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", submittedCount=" + submittedCount +
                ", attachment=" + Arrays.toString(attachment) +
                ", startdate=" + startdate +
                ", enddate=" + enddate +
                '}';
    }
}
