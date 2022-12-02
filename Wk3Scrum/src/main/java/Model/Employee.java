package Model;

import java.util.Date;

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

//        if (this.getEmployeeNumber() > (o.getEmployeeNumber())){
//            return -1;
//        }
    }
}
