package com.sparta;

import Model.BinaryTree;
import Model.Employee;
import Model.EmployeeFactory;
import Model.EmployeeListConverter;
import View.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] employeeSample = EmployeeFactory.getEmployees(UserInput.getUserInput());
        ArrayList<String[]> newStrings = new ArrayList<>();
        List<Employee> EmployeeList = new ArrayList();
        for(String s : employeeSample){
            newStrings.add(s.split(","));
        }

        //TODO - Should add a check for null here and not add that to the list
        for(String[] empData : newStrings){ // Turning the sample of employees into unique Employee objects and storing that employee object in a List
//          At this point you can get each part of employee data using the index values e.g. empData[1]
            EmployeeList.add(EmployeeFactory.makeEmployee(empData[0],empData[1],empData[2],empData[3],empData[4],empData[5]));
        }

        EmployeeListConverter employeeListConverter = new EmployeeListConverter();
        System.out.println(employeeListConverter.convert(EmployeeList));

    }
}