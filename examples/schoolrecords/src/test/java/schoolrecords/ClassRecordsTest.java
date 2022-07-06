package schoolrecords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ClassRecordsTest {

    ClassRecords classRecords;

    @BeforeEach
    void setUp() {
        School school = new School(Paths.get("src/test/resources/school.csv"));
        classRecords = new ClassRecords("Fourth Grade A", new Random(5));
        classRecords.addStudent("Kovács Rita");
        classRecords.addStudent("Nagy Béla");
        classRecords.addStudent("Varga Márton");
        Student firstStudent = classRecords.findStudentByName("Kovács Rita");
        firstStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        firstStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Szabó László")));
        firstStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Dienes Irén")));
        Student secondStudent = classRecords.findStudentByName("Nagy Béla");
        secondStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("biológia"), school.findTutorByName("Dienes Irén")));
        secondStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("matematika"), school.findTutorByName("Tóth Ilona")));
        secondStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("ének-zene"), school.findTutorByName("Németh Lili")));
        Student thirdStudent = classRecords.findStudentByName("Varga Márton");
        thirdStudent.addGrading(new Mark(MarkType.A, school.findSubjectByName("fizika"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.C, school.findSubjectByName("kémia"), school.findTutorByName("Kiss József")));
        thirdStudent.addGrading(new Mark(MarkType.D, school.findSubjectByName("földrajz"), school.findTutorByName("Tóth Ilona")));
    }

    @Test
    void testCreate() {
        assertEquals("Fourth Grade A", classRecords.getClassName());
    }

    @Test
    void testCreateWithEmptyName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ClassRecords("", new Random()));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testAddStudent() {
        assertTrue(classRecords.addStudent("Nagy Klára"));
    }

    @Test
    void testAddStudentAlreadyExists() {
        assertFalse(classRecords.addStudent("Nagy Béla"));
    }

    @Test
    void testAddStudentWithEmptyName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> classRecords.addStudent(""));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testRemoveStudent() {
        assertTrue(classRecords.removeStudent("Nagy Béla"));
    }

    @Test
    void testRemoveStudentDoesNotExists() {
        assertFalse(classRecords.removeStudent("Nagy Klára"));
    }

    @Test
    void testRemoveStudentWithEmptyName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> classRecords.removeStudent(""));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testCalculateClassAverageBySubject() {
        assertEquals(2.75, classRecords.calculateClassAverageBySubject("földrajz"));
    }

    @Test
    void testCalculateClassAverageBySubjectWithEmptySubjectName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> classRecords.calculateClassAverageBySubject(""));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testFindStudentByName() {
        assertEquals("Kovács Rita", classRecords.findStudentByName("Kovács Rita").getName());
    }

    @Test
    void testEmptyStudentNameShouldThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> classRecords.findStudentByName(""));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testEmptyListShouldThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ClassRecords("First Grade", new Random()).findStudentByName("Kovács Rita"));
        assertEquals("No students to search!", ex.getMessage());
    }

    @Test
    void testNonExistingStudentShouldThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> classRecords.findStudentByName("Kiss Rita"));
        assertEquals("No student found with name: Kiss Rita", ex.getMessage());
    }

    @Test
    void testRepetition() {
        assertEquals("Varga Márton", classRecords.repetition().getName());
    }

    @Test
    void testEmptyListException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new ClassRecords("Fourth Grade", new Random()).repetition());
        assertEquals("No students to select for repetition!", ex.getMessage());
    }

    @Test
    void testListSubjectResults() {
        //Given
        List<SubjectResult> list = classRecords.listSubjectResults("földrajz");
        //Then
        assertEquals("Kovács Rita", list.get(0).getStudentName());
        assertEquals(3.5, list.get(0).getSubjectAverage());
        assertEquals(2, list.size());
    }

    @Test
    void testListSubjectResultsWithEmptySubjectName() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> classRecords.listSubjectResults(""));
        assertEquals("Name must not be empty!", ex.getMessage());
    }

    @Test
    void testListStudentNames() {
        assertEquals("Kovács Rita, Nagy Béla, Varga Márton", classRecords.listStudentNames());
    }
}