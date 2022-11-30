package com.sparta.employees;

import java.io.*;
import java.util.*;

public class EmployeeFactory {
    // returns an array containing numEmployees Strings, each representing an Employee as a row from the CSV file
    // 1 <= numEmployees <= 1000
    // may throw IOExceptions, which need to be dealt with in the client code
    // employees.csv should be in the src/main/resources folder in the project
    public static String[] getEmployees(int numEmployees) throws IOException {
        if (numEmployees < 1 || numEmployees > 1000)
            throw new IllegalArgumentException("Argument 'numEmployees' must be between 1 and 1000");
        String employeeLine;
        List<String> result = new ArrayList<>();
        BufferedReader f = new BufferedReader(new FileReader("src/main/resources/employees.csv"));
        // read all the records from the file and add them to the list
        while ((employeeLine = f.readLine()) != null)
            result.add(employeeLine);
        // randomise
        Collections.shuffle(result);
        // return the first numEmployees values as an array
        return result.subList(0,numEmployees).toArray(new String[0]);
    }
}
