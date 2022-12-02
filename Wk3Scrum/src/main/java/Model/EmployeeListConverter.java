package Model;

import java.util.List;

public class EmployeeListConverter {
    public BinaryTree convert (List<Employee> employees){
        BinaryTree bt = new BinaryTree();
        BinaryTree.Node start = new BinaryTree.Node(employees.get(0));
        for (Employee e: employees) {
            bt.add(start,e);
        }
        return bt;
    }
}
