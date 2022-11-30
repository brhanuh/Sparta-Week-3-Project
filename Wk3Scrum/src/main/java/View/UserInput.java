package View;

import java.util.Scanner;

public class UserInput {

    public static int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number of employees");

        int numberOfEmployees = scanner.nextInt();
        return  numberOfEmployees;
    }
}
