package Model;

import org.apache.logging.log4j.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    //TODO create a test that checks the user input for:
    // - user input range of 1 - 1000
    // - user input type - int
    // - Create proper exception handling on the date formatting
}
