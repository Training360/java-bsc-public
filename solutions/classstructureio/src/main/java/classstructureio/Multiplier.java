package classstructureio;

import java.util.Scanner;

public class Multiplier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a szorzandó egész számot: ");
        int number1 = scanner.nextInt();
        System.out.println("Add meg a szorzó egész számot: ");
        int number2 = scanner.nextInt();
        System.out.println(number1 + " * " + number2 + " = " + number1 * number2);
    }
}
