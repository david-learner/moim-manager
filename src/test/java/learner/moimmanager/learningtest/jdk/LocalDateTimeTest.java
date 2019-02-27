package learner.moimmanager.learningtest.jdk;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeTest {
    private static final Logger log =  LoggerFactory.getLogger(LocalDateTimeTest.class);

    @Test
    public void timeDateLocalToLocalDateTime() {
        String time = "2019-02-21T11:30";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        log.debug("localdatetime : {}", localDateTime.toString());
    }
}
