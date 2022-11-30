package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInput {

    public static int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter number between 1 and 1000 ");
            try {
                num = scanner.nextInt();
                if (num > 0 && num <= 1000) {
                    valid = true;
                } else {
                    System.out.println("Out of range.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a valid number.");
                scanner.next();
            }
        }
        System.out.println("This is a list of " + num + " employees");
        return num;
    }
}
