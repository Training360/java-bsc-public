package introexceptionreadfiletestjunit5;

import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordsTest {

    Words words = new Words();

    @Test
    void testGetFirstWordWithA() {
        Path path = Paths.get("src/test/resources/words.txt");
        String firstWordWithA = words.getFirstWordWithA(path);

        assertEquals("Anna", firstWordWithA);
    }

    @Test
    void testGetFirstWordWithANoSuchWord() {
        Path path = Paths.get("src/test/resources/anotherwords.txt");
        String firstWordWithA = words.getFirstWordWithA(path);

        assertEquals("A", firstWordWithA);
    }

    @Test
    void testGetFirstWordWithANotExistingFile() {
        Path path = Paths.get("src/test/resources/xyz.txt");

        IllegalStateException exception = assertThrows(IllegalStateException.class,
                () -> words.getFirstWordWithA(path));
        assertEquals("Can not read file.", exception.getMessage());
    }
}