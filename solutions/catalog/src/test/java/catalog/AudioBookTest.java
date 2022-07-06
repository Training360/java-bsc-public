package catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AudioBookTest {

    @Test
    void testCreate() {
        AudioBook audioBook = new AudioBook("Bárány Boldizsár", Arrays.asList("Szabó Magda"), Arrays.asList("Szombathy Gyula"), 83);

        assertEquals("Bárány Boldizsár", audioBook.getTitle());
        assertEquals(2, audioBook.getContributors().size());
        assertEquals("Szombathy Gyula", audioBook.getContributors().get(1));
        assertEquals(83, audioBook.getLength());
    }

    @Test
    void testMissingTitle() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new AudioBook("", Arrays.asList("Szabó Magda"), Arrays.asList("Szombathy Gyula"), 83));
        assertEquals("Empty title", ex.getMessage());
    }

    @Test
    void testNoAuthor() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new AudioBook("Bárány Boldizsár", null, Arrays.asList("Szombathy Gyula"), 83));
        assertEquals("No author", ex.getMessage());
    }

    @Test
    void testNoPerformer() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new AudioBook("Bárány Boldizsár", Arrays.asList("Szabó Magda"), Arrays.asList(), 83));
        assertEquals("No performer", ex.getMessage());
    }

    @Test
    void testInvalidLength() {
        Exception ex = assertThrows(IllegalArgumentException.class,
                () -> new AudioBook("Bárány Boldizsár", Arrays.asList("Szabó Magda"), Arrays.asList("Szombathy Gyula"), -2));
        assertEquals("Illegal length: -2", ex.getMessage());
    }
}