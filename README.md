# Employee Project

## Overview

Handed with an Excel Spreadsheet consisting the details of over 40 thousand employees,
our task was design and code a programme that would allow the user to request a number of random employees
and search for a specific employee by last name.

Using the Scrum framework, our team of 5 designed, developed and tested
our programme with an emphasis on implementing good practice of the
SOLID principles and Object-Oriented Programming.

## Specific Requirements

### Scrum
- We assigned roles with Patryk being selected as our Scrum Master
- The Project would consist of two Sprints, each lasting a day

- A Product Backlog was created and increments from there were chosen for our Sprints
- Each sprint consisted of a Sprint Plan, Backlog, Retrospective and Review
- Each day included a daily stand-up meeting where we discussed our progress
and any changes that needed to be made

### Product

1. The provided class, EmployeeFactory.java needed to be added to a
suitable package within our Project

2. Add the provided sample data file to the src/main/resources folder
in our Project

3. Be able to generate an array of random employee data of size n(1 <= n <= 1000)
when calling EmployeeFactory.getEmployees

4. Convert each element in the array into an Employee object, having created
a suitable class, and store in a List using a suitable concrete type

5. Convert the List to a binary tree using a class created for this purpose
  - A nested class should represent a node in the Retrospective
  - The tree should allow for multiple employees with the same last name
  - Allow the user to search for a specific employee by last name

## User Stories

Our first step towards creating the programme was to write user stories to cement our
understanding of the require product. We had to think of what the user would want from
the product. We also had to think of how a developer would want the code to be formatted
in case they want to make alterations.

| As a user I want... | As a developer I want...|
| --------            | ---------------------|
To be asked how many employees I can sample so that I can control the amount | I want to include a try and catch method so that incorrect user input does not terminate the program  |
| To be provided with a way to search for an employee so that I can find specific employees | I want to sort the employees into a binary tree so that searching is done more efficiently
| To be able to search through a large number of samples so that I can test large data samples| I want to use a collection type that can store a lot of data so that there are no errors when 1000 employees are sampled
|To interact with a simple user-friendly interface so that I do not get confused using the program| I want the design architecture to follow the MCV format so that the user only sees what is necessary
I want the program to work with the Spreadsheet provided so that I know it is the right data| I want the program to work with the csv file so that it is compatible with the data

## Sprint 1

### Plan
Scrum Master, Patryk led the first sprint plan and we assigned the following increments to each person:

| Patryk | Cameron | Liam | Hanibal | JB |
|----- | ----- | ----| -----| -----|
|Write logic for a user input class | Convert Employees spreadsheet to csv| Document the overview of project| Set up the collaborative Github repository | Make intellij template and upload to the repository|
|Create employee class with required fields | Add csv file to resources | Document user stories | Add Dependencies for log4j and JUnit | Conduct tests on working code
|Create and write logic for lastname search class | Add provided employeeFactory class |     | Add Binary Tree Class    | Research Binary Tree logic|
|         | Write logic for storing the data from employeeFactory to a suitable collections type |




### Review

All of the increments set for Sprint 1 were completed other than the tests which are an ongoing process.
On course to finish the product on time.

### Retrospective

As a team we were good at completing our individual assignments and were collaborating well on the call to troubleshoot issues such as
merging pushes to Github and pieces of code that were not quite working. After finishing individual tasks, we collectively tried to solve the logic
for converting the employee list into a Binary Tree. However, Patryk realised it would be more efficient for Cameron and Haniabl to continue working on
the problem whilst the other continued with other tasks. This is a principle we carried forward into Sprint 2.

## Sprint 2
### Plan
The second sprint will consist of fewer but more difficult tasks. The difficulty of the code means that it will be worked on collaboratively and tasks such as testing
and documenting will have to wait for working code to be made.

|Patryk | Cameron | Liam | Hanibal | JB |
|----- | ----- | ----| -----| -----|
|Write code for searching the Binary Tree | Write logic for converting List into Binary Tree | Document the Sprints | Write logic for converting List into Binary Tree| Continue Tests for working logic|
|Refactor into MCV architecture| Write code for searching the Binary Tree | Document the finished working code | rite code for searching the Binary Tree |


### Review

All of the backlog was completed in this sprint meaning it was a successful product that fulfilled the requirements.

### Retrospective
As a team were efficient and each completed our respective tasks. We followed the guidance of the scrum master well and worked with scrum principles.
We could have rotated more with respect to the tasks, however, since it was a short project there was not time for that.

## Finished Program
The result will be demonstrated through each stage of the architecture.

### View
The first class in our View package was "UserInput". The purpose of this class is to receive the number of employees that the user wishes to search for.
A try and catch statement is used facilitate incorrect user input.
```java
public class UserInput {

    public static int getUserInput() {

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter number between 1 and 1000: ");
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
        System.out.println("This is a list of " + num + " employees: ");
        return num;
    }
}
```
The second class in the View package is "UserInputForSearch". This class is designed to allow the user to search through the requested employees using
a given last name. RegEx is used to specify the format requirements for the last name and a try and catch statement is used to facilitate incorrect input.
```java
public class UserInputForSearch {
    public static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        String lastName = "";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the last name of an employee: ");
            try {
                lastName = scanner.next();
                if (lastName != null && lastName.matches("^[a-zA-Z-]*$")) {
                    valid = true;
                } else {
                    System.out.println("Please enter a correct format");
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a correct format.");
                scanner.next();
            }
        }
        System.out.println("Thank you");
        return lastName;
    }
}
```
### Control
The first class in the Control package is "ControllerClass". The purpose of this class is, when started, to instruct the model to conduct the search for the employee and passes through
the last name supplied by the View package. It also then instructs the view to print the result of the search.
```java
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
```
The other class in the Control package is the Starter class. It does as it says and initialises the ControllerClass and in turn keeps the Main Class clean.

```java
public class Starter {

    public static void start() {
        ControllerClass cc = new ControllerClass();
        cc.printEmployeesToConsole();
        cc.searchByLastName();

    }

}
```
### Model
The first class in our Model Package is "Employee". In this class we define the variables that exist in an Employee object and create a constructor for them.
Getters and Setters are always generated for each variable. The class is made to implement the Comparable interface and the compareTo method is overridden to compare Employee objects alphabetically by last name.
The toString and fullToString method are also overridden so the employee object can be printed out as a String.
```java
public class Employee implements Comparable<Employee> {

    private int employeeNumber;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private char gender;
    private Date dateOfEmployment;

    public Employee(int employeeNumber, Date dateOfBirth, String firstName, String lastName, char gender, Date dateOfEmployment) {
        this.employeeNumber = employeeNumber;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfEmployment = dateOfEmployment;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public String toString() {
        return
                "lastName='" + lastName;
    }

    public String fullToString(){
        return
                "Employee Number: " + this.employeeNumber + ", " +
                        "Full name: " + this.firstName + " " + this.lastName + ", " +
                        "Gender: " + this.gender + ", " +
                        "Date of Birth: " + this.dateOfBirth + ", " +
                        "Date of Employment: " + this.dateOfEmployment;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setDateOfEmployment(Date dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public int compareTo(Employee o) {
        return(this.getLastName().compareTo(o.getLastName()));
    }
}
```
The next class is the "EmployeeFactory" class. Using the code provided this class converts the data from the csv into an ArrayList of Strings with each string being an Employees details
for how many employees were requested. The class then turns each of these strings into an employee object and adds them to an object ArrayList of Employee as defined in the Employee Class.

```java
public class EmployeeFactory {
    public static Logger logger = LogManager.getLogger();

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

}
```
The next class in "BinaryTree". This consists of the logic to sort the Employee List into a Binary Tree to make it quicker to search through. A nested-Class is used to define a Node on the tree.
This Binary Tree allows for duplicates of the same last-name and passes them to the left node. The class includes the logic for searching the Binary Tree and what would be printed if the last name was found/not found.

```java
public class BinaryTree {
    public static class Node{
        Employee data;
        Node left;
        Node right;

        public Node(Employee data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public void add(Node start, Employee data){

        if (start.data.compareTo(data) == 0){
            if (start.left == null){
                start.left = new Node(data);
            } else {
                add(start.left, data);
            }
        }
        else if(data.compareTo(start.data) < 0){
            if (start.left == null){
                start.left = new Node(data);
            }
            else {
                add(start.left, data);
            }
        }
        else if (data.compareTo(start.data) > 0){
            if (start.right == null){
                start.right = new Node(data);
            }
            else {
                add(start.right, data);
            }
        }
    }
    public void printNodes(Node node) {
        // base case
        if (node == null) {
            return;
        }
        System.out.println(node);
        printNodes(node.left);
        printNodes(node.right);
    }
    public void search(Node n, String s){
        if (n.equals(null)){
            System.out.println(n + " is null");
        }
        else if (s.equals(n.data.getLastName())){
            System.out.println(n.data.fullToString());
            if (n.left != null && n.left.data.getLastName().equals(s)){
                search(n.left,s);
            }
        }
        else if(s.compareTo(n.data.getLastName()) < 0){
            if(n.left != null) {
                search(n.left, s);
            } else
                System.out.println("Employee not in the sample");
        }
        else {
            if (n.right != null) {
                search(n.right, s);
            } else
                System.out.println("Employee not in the sample");
        }
    }
}
```
The final class in our Model package is the "EmployeeListConverter". This returns a binary tree from the Employee List.
```java
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
```















# Sparta-Week-3-Project


Using the binary tree logic developed in class, our ***heroes***
collaborated to integrate the binary tree to search using the newly
discovered 'CompareTo'
