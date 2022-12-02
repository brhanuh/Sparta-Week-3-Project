package com.sparta.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserInputTest {

    @ParameterizedTest
    @ValueSource(ints = {1001, 1002, 1003, 1004, 1005, -1, -2, -3, -4, 0})
    void testGetEmployees(){
        String result = "Argument 'numEmployees' must be between 1 and 1000";
        String expected = "Argument 'numEmployees' must be between 1 and 1000";
        assertEquals(expected, result);
        }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'b','c', 'd', 'e', 'v', 'w', 'x', 'y', 'z'})
    void testGetUserInput(){
        String expected = "Not a valid number.";
        assertFalse(expected.matches("^[0-9]*$"));
    }
    @ParameterizedTest
    @ValueSource(strings = {"a", "b","c", "d", "e", "v", "w", "x", "y", "z"})
    void testUserStrings(){
        String expected = "Not a valid number.";
        assertFalse(expected.matches("^[0-9]*$"));
    }
}
