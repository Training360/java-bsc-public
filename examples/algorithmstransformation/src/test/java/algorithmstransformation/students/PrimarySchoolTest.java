package algorithmstransformation.students;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimarySchoolTest {

    PrimarySchool primarySchool;

    @BeforeEach
    void setUp() {
        List<Person> people = Arrays.asList(new Person("Kiss Béla", 56, "1118 Budapest, Sasadi út 34."),
                new Person("Nagy Béla", 10, "1031 Budapest, Vizimolnár utca 22."),
                new Person("Nagy Erika", 6, "1031 Budapest, Vizimolnár utca 22."),
                new Person("Németh Gyöngyi", 32, "1144 Budapest, Füredi utca 7."),
                new Person("Asztalos László", 8, "1149 Budapest, Nagy Lajos király útja 104."),
                new Person("Gál Tamás", 14, "1149 Budapest, Nagy Lajos király útja 12."),
                new Person("Siklós János", 43, "1144 Budapest, Füredi utca 7."));
        primarySchool = new PrimarySchool(people);
    }

    @Test
    void testGetStudents() {
        List<Student> students = primarySchool.getStudents();

        assertEquals(4, students.size());
    }
}