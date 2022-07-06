package schoolrecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarkTest {

    static final Subject SUBJECT = new Subject("matematika");

    static final Tutor TUTOR = new Tutor("Nagy Lilla", Arrays.asList(SUBJECT));

    @Test
    void testNullParameterShouldThrowException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new Mark(MarkType.A, null, TUTOR));
        assertEquals("Both subject and tutor must be provided!", ex.getMessage());
    }

    @Test
    void testCreate() {
        Mark mark = new Mark(MarkType.A, SUBJECT, TUTOR);
        assertEquals(MarkType.A, mark.getMarkType());
        assertEquals(SUBJECT, mark.getSubject());
        assertEquals(TUTOR, mark.getTutor());
        assertEquals("matematika - excellent(5)", mark.toString());
    }
}