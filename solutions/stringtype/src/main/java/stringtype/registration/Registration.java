package stringtype.registration;

import java.util.Scanner;

public class Registration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Felhasználónév:");
        String username = scanner.nextLine();

        System.out.println("Jelszó:");
        String password = scanner.nextLine();

        System.out.println("Jelszó még egyszer:");
        String password2 = scanner.nextLine();

        System.out.println("Email cím:");
        String email = scanner.nextLine();

        UserValidator userValidator = new UserValidator();

        String message = userValidator.isValidUsername(username) ? "" : "Invalid felhasználónév\n";
        message += userValidator.isValidPassword(password, password2) ? "" : "Invalid vagy nem egyező jelszó\n";
        message += userValidator.isValidEmail(email) ? "" : "Invalid email cím";

        System.out.println(message.length() > 0 ? message : "Sikeres regisztráció");
    }
}
