package schoolrecords;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    School school;

    @BeforeEach
    void init() {
        school = new School(Paths.get("src/test/resources/school.csv"));
    }

    @Test
    void testFindTutorByName() {
        Tutor tutor = school.findTutorByName("Szabó László");

        assertEquals("Szabó László", tutor.getName());
        assertEquals(true, tutor.isTutorTeachingSubject("fizika"));
        assertEquals(false, tutor.isTutorTeachingSubject("rajz"));
    }

    @Test
    void testFindTutorByNameNotExistingTutor() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> school.findTutorByName("Szabó Géza"));
        assertEquals("Can't find tutor with this name!", ex.getMessage());
    }

    @Test
    void testFindSubjectByName() {
        assertEquals("matematika", school.findSubjectByName("matematika").getName());
    }

    @Test
    void testFindSubjectByNameNotExistingSubject() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> school.findSubjectByName("magyar irodalom"));
        assertEquals("Can't find subject with this name!", ex.getMessage());
    }

    @Test
    void testLoadFromNotExistingFile() {
        IllegalStateException ex = assertThrows(IllegalStateException.class,
                () -> school = new School(Paths.get("src/test/resources/xyz.csv")));
        assertEquals("Can't load subjects and tutors from file.", ex.getMessage());
    }
}