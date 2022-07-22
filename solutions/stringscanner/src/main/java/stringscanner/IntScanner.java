package stringscanner;

import java.util.Scanner;

public class IntScanner {

    public String convertInts(String ints) {
        Scanner scanner = new Scanner(ints).useDelimiter(";");
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            if (number > 100) {
                sb.append(number);
                sb.append(",");
            }
        }
        String result = sb.toString();
        if (result.length() == 0) {
            return result;
        }
        return result.substring(0, result.length() - 1);
    }
}
