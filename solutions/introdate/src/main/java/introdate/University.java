package introdate;

import java.time.LocalDateTime;

public class University {

    public static void main(String[] args) {
        Exam firstExam = new Exam("Statics", LocalDateTime.of(2021, 6, 5, 9, 0));
        Exam secondExam = new Exam("Ancient history", LocalDateTime.of(2021, 5, 28, 10, 30));
        LocalDateTime firstExamDate = firstExam.getExamDate();
        LocalDateTime secondExamDate = secondExam.getExamDate();

        System.out.println(firstExam.getSubject());
        System.out.println(firstExamDate);
        System.out.println(firstExamDate.getYear());
        System.out.println(firstExamDate.getMonthValue());
        System.out.println(firstExamDate.getDayOfMonth());
        System.out.println(firstExamDate.getHour());
        System.out.println(firstExamDate.getMinute());

        System.out.println(firstExamDate.isBefore(secondExamDate));
        System.out.println(firstExamDate.isAfter(secondExamDate));

        System.out.println(firstExam.getMessage());
        System.out.println(secondExam.getMessage());
    }
}
