package Model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    @DisplayName("Given a number from 1 to 1000 method should return String[] of the same size")
    public void getEmplyeesTest_ShouldReturnRequiredNumber() {
        int given = 108;
        int excpected = EmployeeFactory.getEmployees(108).length;
        Assertions.assertEquals(given, excpected);
    }

    @Test
    @DisplayName("Given a number outside of 1 to 1000 method should throw an Exception")
    public void getEmployeesTest_ShouldThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            EmployeeFactory.getEmployees(1080);
        });
        assertEquals("Argument 'numEmployees' must be between 1 and 1000", exception.getMessage());
    }

    @Test
    @DisplayName("Given all arguments of method should return a new Employee object")
    public void makeEmployeeTest_ShouldReturnObjectOfEmployee() {
        assertInstanceOf(Employee.class, EmployeeFactory.makeEmployee("123", "12/12/2005", "John",
                "Johnson", "M", "13/11/1011"));
    }
}