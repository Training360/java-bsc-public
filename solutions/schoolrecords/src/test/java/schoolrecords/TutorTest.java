package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TutorTest {

    @Test
    void testTutorTeachingSubject() {
        //Given
        Tutor tutor = new Tutor("Nagy Csilla", Arrays.asList(new Subject("matematika"), new Subject("fizika")));
        //Then
        assertEquals("Nagy Csilla", tutor.getName());
        assertTrue(tutor.isTutorTeachingSubject("fizika"));
    }

    @Test
    void testTutorDoesNotTeachingSubject() {
        //Given
        Tutor tutor = new Tutor("Nagy Csilla", Arrays.asList(new Subject("matematika"), new Subject("fizika")));
        //Then
        assertFalse(tutor.isTutorTeachingSubject("biológia"));
    }
}