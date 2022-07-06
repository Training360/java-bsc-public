package schoolrecords;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubjectResultTest {

    @Test
    void testCreate() {
        SubjectResult subjectResult = new SubjectResult("Kiss József", 3.54);

        assertEquals("Kiss József", subjectResult.getStudentName());
        assertEquals(3.54, subjectResult.getSubjectAverage());
        assertEquals("Kiss József: 3.54", subjectResult.toString());
    }
}
