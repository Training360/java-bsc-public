package introdate;

import java.time.LocalDateTime;

public class Exam {

    private String subject;

    private LocalDateTime examDate;

    public Exam(String subject, LocalDateTime examDate) {
        this.subject = subject;
        this.examDate = examDate;
    }

    public String getSubject() {
        return subject;
    }

    public LocalDateTime getExamDate() {
        return examDate;
    }

    public String getMessage() {
        return "The exam in subject " + subject +
                " will be on the " + examDate.getDayOfMonth() +
                "th of " + examDate.getMonth() + ".";
    }
}
