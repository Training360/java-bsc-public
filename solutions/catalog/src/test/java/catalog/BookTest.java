package catalog;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testCreate() {
        Book book = new Book("Harry Potter", 600, Arrays.asList("J.K. Rowling", "Joseph Jackson"));

        assertEquals(2, book.getContributors().size());
        assertEquals("Joseph Jackson", book.getContributors().get(1));
        assertEquals("Harry Potter", book.getTitle());
        assertEquals(600, book.getNumberOfPages());
    }

    @Test
    void testMissingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Book("", 600, Arrays.asList("J.K. Rowling", "Joseph Jackson")));
        assertEquals("Empty title", ex.getMessage());
    }

    @Test
    void testInvalidNumberOfPages() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Book("Harry Potter", -1, Arrays.asList("J.K. Rowling", "Joseph Jackson")));
        assertEquals("Illegal number of pages: -1", ex.getMessage());
    }

    @Test
    void testNoPerformer() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new Book("Harry Potter", 600, null));
        assertEquals("No authors", ex.getMessage());
    }

    @Test
    void testCreateCourseBook() {
        Book book = new CourseBook("Matematika feladatgyűjtemény 6.", 300,
                new ArrayList<>(Arrays.asList("Czeglédy Istvánné", "Dr. Czeglédy István", "Dr. Hajdu Sándor")), "Szalontai Tibor");

        assertEquals(4, book.getContributors().size());
        assertEquals("Dr. Hajdu Sándor", book.getContributors().get(2));
        assertEquals("Szalontai Tibor", book.getContributors().get(3));
        assertEquals("Matematika feladatgyűjtemény 6.", book.getTitle());
        assertEquals(300, book.getNumberOfPages());
    }

    @Test
    void testGetLector() {
        CourseBook book = new CourseBook("Matematika feladatgyűjtemény 6.", 300,
                new ArrayList<>(Arrays.asList("Czeglédy Istvánné", "Dr. Czeglédy István", "Dr. Hajdu Sándor")), "Szalontai Tibor");

        assertEquals("Szalontai Tibor", book.getLector());
    }

    @Test
    void testCreateWithEmptyLector() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new CourseBook("Matematika feladatgyűjtemény 6.", 300,
                        Arrays.asList("Czeglédy Istvánné", "Dr. Czeglédy István", "Dr. Hajdu Sándor"), ""));
        assertEquals("No lector", ex.getMessage());
    }
}