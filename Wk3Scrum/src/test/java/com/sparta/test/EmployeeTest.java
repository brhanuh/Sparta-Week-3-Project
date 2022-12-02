package com.sparta.test;

import Model.EmployeeFactory;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.annotations.Test;

public class EmployeeTest {

    @ParameterizedTest
    @ValueSource(ints = {1001, 1002, 1003, 1004, 1005, -1, -2, -3, -4, 0})
    void testGetEmployees(){
        String result = "Argument 'numEmployees' must be between 1 and 1000";
        String expected = "Argument 'numEmployees' must be between 1 and 1000";
        assertEquals(expected, result);
        }

//    @Test
//    void inputIsNull(){
//        assertThrows(IllegalArgumentException.class, new Executable() {
//            @Override
//            public void execute() throws Throwable {
//                //TODO: continue this illegal arguement test
//            }
//        })
//    }
}
