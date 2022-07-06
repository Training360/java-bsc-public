package catalog;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorsTest {

    @Test
    void testIsBlank() {
        assertTrue(Validators.isBlank(null));
        assertTrue(Validators.isBlank(""));
        assertTrue(Validators.isBlank("    "));
        assertFalse(Validators.isBlank("a"));
        assertFalse(Validators.isBlank("     a       "));
    }

    @Test
    void testIsEmpty() {
        assertTrue(Validators.isEmpty(null));
        assertTrue(Validators.isEmpty(Arrays.asList()));
        assertFalse(Validators.isEmpty(Arrays.asList("aaa")));
        assertFalse(Validators.isEmpty(Arrays.asList("aaa", "bbb")));
    }
}
