package introexceptionthrow;

public class Validation {

    public void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Not valid name!");
        }
    }

    public void validateAge(String ageText) {
        if (ageText.length() == 0) {
            throw new IllegalArgumentException("Age can not be empty!");
        }
        char[] chars = ageText.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("Age is not a number!");
            }
        }
        int age = Integer.parseInt(ageText);
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Not valid age!");
        }
    }
}
