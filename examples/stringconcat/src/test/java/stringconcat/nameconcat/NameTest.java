package stringconcat.nameconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    void testConcatNameWesternStyle() {
        assertEquals("Mr. John G Smith", new Name("Smith", "G", "John", Title.MR).concatNameWesternStyle());
        assertEquals("John G Smith", new Name("Smith", "G", "John", null).concatNameWesternStyle());
        assertEquals("Mr. John Smith", new Name("Smith", "", "John", Title.MR).concatNameWesternStyle());
        assertEquals("Mr. John Smith", new Name("Smith", null, "John", Title.MR).concatNameWesternStyle());
    }

    @Test
    void testConcatNameHungarianStyle() {
        assertEquals("Mr. Smith G John", new Name("Smith", "G", "John", Title.MR).concatNameHungarianStyle());
        assertEquals("Smith G John", new Name("Smith", "G", "John", null).concatNameHungarianStyle());
        assertEquals("Mr. Smith John", new Name("Smith", "", "John", Title.MR).concatNameHungarianStyle());
    }
}