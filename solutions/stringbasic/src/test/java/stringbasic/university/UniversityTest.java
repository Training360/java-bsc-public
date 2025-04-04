package stringbasic.university;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniversityTest {

    Student student;

    Student sameStudent;

    Student anotherStudent;

    University university;

    @BeforeEach
    void init() {
        Person person = new Person("Kovács Péter", "kovacsp@gmail.com", "123456789",
                "12345678-87654321-12345678", "+3620-1234567");
        student = new Student(person, "A1B2C3", "9876543210");
        university = new University();
        Person samePerson = new Person("Peter Schmidt", "pschmidt@gmail.com", "1010101010",
                "12345678-87654321-00000000", "+43-681-12345678");
        sameStudent = new Student(samePerson, "A1B2C3", "9876543210");
        Person anotherPerson = new Person("Kovács Péter", "kovacsp@gmail.com", "123456788",
                "12345678-87654321-12345678", "+3620-1234567");
        anotherStudent = new Student(anotherPerson, "D4E5F6", "0123456789");
    }

    @Test
    void testAreEqual() {
        assertEquals(true, university.areEqual(student, sameStudent));
        assertEquals(false, university.areEqual(student, anotherStudent));
    }

    @Test
    void testNoStudents() {
        assertEquals(0, university.getStudents().size());
    }

    @Test
    void testAddStudent() {
        university.addStudent(student);

        assertEquals(1, university.getStudents().size());
    }
}