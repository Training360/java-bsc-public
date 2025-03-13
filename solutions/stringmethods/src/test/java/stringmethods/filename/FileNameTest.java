package stringmethods.filename;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileNameTest {

    FileName fileName = new FileName();

    @Test
    void testFindLastCharacter() {
        assertEquals('f', fileName.findLastCharacter("abcdef"));
        assertEquals('f', fileName.findLastCharacter("abcdef \t  \n "));
    }

    @Test
    void testFindFileExtension() {
        assertEquals("dat", fileName.findFileExtension("record.dat"));
    }

    @Test
    void testIdentifyFilesByExtension() {
        assertEquals(true, fileName.identifyFilesByExtension("mm", "tematika.mm"));
        assertEquals(false, fileName.identifyFilesByExtension("md", "tematika.mm"));
    }

    @Test
    void testCompareFilesByName() {
        assertEquals(true, fileName.compareFilesByName("String.java", "String.JAVA"));
        assertEquals(false, fileName.compareFilesByName("String.java", "Sting.java"));
    }

    @Test
    void testChangeExtensionToLowerCase() {
        assertEquals("String.java", fileName.changeExtensionToLowerCase("String.JAVA"));
    }

    @Test
    void testReplaceStringPart() {
        assertEquals("picture.png", fileName.replaceStringPart("picture.png", "jpeg", "jpg"));
        assertEquals("picture.jpg", fileName.replaceStringPart("picture.jpeg", "jpeg", "jpg"));
        assertEquals("long_descriptive_name.txt", fileName.replaceStringPart("long descriptive name.txt", " ", "_"));
    }
}