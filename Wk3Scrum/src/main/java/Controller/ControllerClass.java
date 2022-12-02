package Controller;

import Model.BinaryTree;
import Model.Employee;
import Model.EmployeeFactory;
import Model.EmployeeListConverter;
import View.UserInput;

import java.util.List;

public class ControllerClass {

    EmployeeListConverter employeeListConverter = new EmployeeListConverter();
    BinaryTree binaryTree = new BinaryTree();

    public List<Employee>  printEmployeesToConsole() {
        List<Employee> listOfEmployeeObjects = EmployeeFactory.getListOfEmployeeObjects(UserInput.getUserInput());
        {
            for (Employee e:listOfEmployeeObjects ) {
                System.out.println(e.fullToString());
            }
        } return listOfEmployeeObjects;
    }


}
