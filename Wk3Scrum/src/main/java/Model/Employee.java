package Model;

import java.util.Date;

public class Employee {

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

}
/*
Suggestion, make ths class abstract
    public abstract class Employee {

    public abstract void employeeNumber;
    public abstract void dateOfBirth;
    public abstract void firstName;
    public abstract void lastName;
    public abstract void gender;
    public abstract void dateOfEmployment;

    with another abstract class to generate the individual spartans
 */