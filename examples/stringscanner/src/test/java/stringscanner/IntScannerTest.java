package stringscanner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntScannerTest {

    @Test
    void testConvertInts() {
        IntScanner intScanner = new IntScanner();

        assertEquals("107,123,198", intScanner.convertInts("5;3;107;12;123;18;198"));
        assertEquals("107", intScanner.convertInts("107"));
        assertEquals("", intScanner.convertInts("5;2;3;7;89;10"));
        assertEquals("", intScanner.convertInts("5"));
        assertEquals("", intScanner.convertInts(""));
    }
}