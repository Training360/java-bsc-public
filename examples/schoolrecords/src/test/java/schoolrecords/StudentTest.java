package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    static final Subject MATH = new Subject("matematika");

    static final Tutor TUTOR = new Tutor("Nagy Lilla", Arrays.asList(MATH, new Subject("történelem")));

    @Test
    void testEmptyNameShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student(""));
        assertEquals("Student name must not be empty!", ex.getMessage());
    }

    @Test
    void testNullMarkInGradingShouldThrowException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new Student("Kovács").addGrading(null));
        assertEquals("Mark must not be null!", ex.getMessage());
    }

    @Test
    void testGrading() {
        //Given
        Student student = new Student("Kovács Sándor");
        //When
        student.addGrading(new Mark(MarkType.A, MATH, TUTOR));
        student.addGrading(new Mark(MarkType.A, MATH, TUTOR));
        //Then
        assertEquals("Kovács Sándor marks: matematika - excellent(5), matematika - excellent(5)", student.toString());
    }

    @Test
    void testCalculateSubjectAverage() {
        //Given
        Student student = new Student("Kovács Sándor");
        //When
        student.addGrading(new Mark(MarkType.A, MATH, TUTOR));
        student.addGrading(new Mark(MarkType.C, MATH, TUTOR));
        student.addGrading(new Mark(MarkType.C, new Subject("történelem"), TUTOR));
        student.addGrading(new Mark(MarkType.D, MATH, TUTOR));
        //Then
        assertEquals(3.33, student.calculateSubjectAverage("matematika"));
    }

    @Test
    void testCalculateSubjectAverageIfMarksEmpty() {
        //Given
        Student student = new Student("Kovács Sándor");
        //Then
        assertEquals(0.0, student.calculateSubjectAverage("matematika"));
    }

    @Test
    void testCalculateSubjectAverageIfNoMarkFromSubject() {
        //Given
        Student student = new Student("Kovács Sándor");
        //When
        student.addGrading(new Mark(MarkType.A, MATH, TUTOR));
        student.addGrading(new Mark(MarkType.C, new Subject("történelem"), TUTOR));
        student.addGrading(new Mark(MarkType.D, MATH, TUTOR));
        //Then
        assertEquals(0.0, student.calculateSubjectAverage("földrajz"));
    }
}