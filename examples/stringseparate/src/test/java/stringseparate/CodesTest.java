package stringseparate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CodesTest {

    @Test
    void testGetCodesStartWithLetter() {
        Codes code = new Codes();
        List<String> codes = Arrays.asList("T57fbj", "xtcu45", "4CHU7", "857Gdob", "f578GVHd");

        assertEquals("Betűvel kezdődő kódok: T57fbj, xtcu45, f578GVHd", code.getCodesStartWithLetter(codes));
    }
}