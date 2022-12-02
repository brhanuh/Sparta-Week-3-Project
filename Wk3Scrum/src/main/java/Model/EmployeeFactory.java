package Model;

import View.UserInput;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class EmployeeFactory {
    public static Logger logger = LogManager.getLogger();
    // returns an array containing numEmployees Strings, each representing an Employee as a row from the CSV file
    // 1 <= numEmployees <= 1000
    // may throw IOExceptions, which need to be dealt with in the client code
    // employees.csv should be in the src/main/resources folder in the project
    public static String[] getEmployees(int numEmployees) {
        if (numEmployees < 1 || numEmployees > 1000)
            throw new IllegalArgumentException("Argument 'numEmployees' must be between 1 and 1000");
        String employeeLine;
        List<String> result = new ArrayList<>();
        BufferedReader f = null;
        try {
            f = new BufferedReader(new FileReader("src/main/resources/employees.csv")); // Could test this maybe by renaming the employees file and see if this try fires
        } catch (FileNotFoundException | NullPointerException e) {
            logger.log(Level.ERROR, "employees.csv file not found");
            logger.error(e.getMessage(),e);
        }
        // read all the records from the file and add them to the list
        while (true) {
            try {
                if (!((employeeLine = f.readLine()) != null)) break;
            } catch (IOException e) {
                logger.log(Level.ERROR, "Error reading file.");
                logger.error(e.getMessage(), e);
                employeeLine = null;
            }
            result.add(employeeLine);
        }
        // randomise
        Collections.shuffle(result);
        // return the first numEmployees values as an array
        return result.subList(0,numEmployees).toArray(new String[0]);
    }

    /** Method for creating an employee
     * Takes String arguments for each field and converts them here,
     * first checks if any argument is null,
     * Can add null checks here and return null*/
    //TODO add null checks
    public static Employee makeEmployee(String employeeNumber, String dateOfBirth, String firstName, String lastName, String gender, String dateOfEmployment){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        int intEmployeeNumber = Integer.parseInt(employeeNumber);
        Date dateDateOfBirth;
        try {
            dateDateOfBirth = formatter.parse(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        char charGender = gender.charAt(0);
        Date dateDateOfEmployment;
        try {
            dateDateOfEmployment = formatter.parse(dateOfEmployment);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new Employee( intEmployeeNumber, dateDateOfBirth, firstName, lastName, charGender, dateDateOfEmployment);
    }

    public static List<Employee> getListOfEmployeeObjects() {

        String[] employeeSample = EmployeeFactory.getEmployees(UserInput.getUserInput());
        ArrayList<String[]> newStrings = new ArrayList<>();
        List<Employee> EmployeeList = new ArrayList<>();
        for (String s : employeeSample) {
            newStrings.add(s.split(","));
        }

        for (String[] empData : newStrings) {
            EmployeeList.add(EmployeeFactory.makeEmployee(empData[0], empData[1], empData[2], empData[3], empData[4], empData[5]));
        } return EmployeeList;
    }
    //TODO create a test that checks the user input for:
    // - user input type - int
    // - Create proper exception handling on the date formatting
}
