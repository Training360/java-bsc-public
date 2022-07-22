package stringbuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeValidatorTest {

    @Test
    void testIsPalindrome() {
        PalindromeValidator palindromeValidator = new PalindromeValidator();

        assertEquals(true, palindromeValidator.isPalindrome("Racecar"));
        assertEquals(false, palindromeValidator.isPalindrome("start"));
        assertEquals(true, palindromeValidator.isPalindrome(""));
        assertEquals(true, palindromeValidator.isPalindrome("\n\t"));
    }
}