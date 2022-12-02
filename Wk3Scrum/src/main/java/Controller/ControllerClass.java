package Controller;

import Model.BinaryTree;
import Model.Employee;
import Model.EmployeeFactory;
import Model.EmployeeListConverter;
import View.UserInputForSearch;

import java.util.List;

public class ControllerClass {
    List<Employee> listOfEmployeeObjects = EmployeeFactory.getListOfEmployeeObjects();

    public void  printEmployeesToConsole() {
        {
            for (Employee e:listOfEmployeeObjects ) {
                System.out.println(e.fullToString());
            }
        }
    }
    public void searchByLastName(){
        BinaryTree bt = (new EmployeeListConverter().convert(listOfEmployeeObjects));
        final BinaryTree.Node root = new BinaryTree.Node(listOfEmployeeObjects.get(0));
        for (Employee e : listOfEmployeeObjects) {
            bt.add(root, e);
        }
        bt.search(root, UserInputForSearch.getUserInput());
    }
}
