package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputForSearch {
    public static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String lastName = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the last name of an employee: ");
            try {
                lastName = scanner.next();
                if (lastName != null && lastName.matches("^[a-zA-Z ]*$")) {
                    valid = true;
                } else {
                    System.out.println("Please enter a correct format");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a correct format.");
                scanner.next();
            }
        }
        System.out.println("Thank you");
        return lastName;
    }
}
