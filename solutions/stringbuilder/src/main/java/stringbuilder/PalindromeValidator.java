package stringbuilder;

public class PalindromeValidator {

    public boolean isPalindrome(String text) {
        text = text.trim();
        StringBuilder sb = new StringBuilder(text);

        return text.equalsIgnoreCase(sb.reverse().toString());
    }
}
