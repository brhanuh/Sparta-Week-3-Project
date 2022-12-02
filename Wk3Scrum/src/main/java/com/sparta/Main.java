package com.sparta;

import View.Starter;

public class Main {
    public static void main(String[] args) {

        Starter s = new Starter();
        s.start();

//        String[] employeeSample = EmployeeFactory.getEmployees(UserInput.getUserInput());
//        ArrayList<String[]> newStrings = new ArrayList<>();
//        List<Employee> EmployeeList = new ArrayList<>();
//        for (String s : employeeSample) {
//            newStrings.add(s.split(","));
//        }

//        //TODO - Should add a check for null here and not add that to the list
//        for (String[] empData : newStrings) {
//            EmployeeList.add(EmployeeFactory.makeEmployee(empData[0], empData[1], empData[2], empData[3], empData[4], empData[5]));
//        }
//        Collections.sort(EmployeeList);

//        BinaryTree bt = (new EmployeeListConverter().convert(EmployeeList));
//        final BinaryTree.Node root = new BinaryTree.Node(EmployeeList.get(0));
//        for (Employee e : EmployeeList) {
//            bt.add(root, e);
//        }
//        bt.printNodes(root);
//
//        for(Employee e : EmployeeList){
//            System.out.println(e.fullToString());
//        }
//
//        System.out.println("\n");
//
//        bt.search(root, UserInputForSearch.getUserInput());

    }
}