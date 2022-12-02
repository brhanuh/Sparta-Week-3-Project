package com.sparta.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserInputSearchTest {
    @ParameterizedTest
    @ValueSource(strings = {"a1", "b2","c3", "d4", "e5", "v6", "w7", "x8", "y9", "z0"})
    void testUserStrings(){
        String expected = "Please enter a correct format";
        assertTrue(expected.matches("^[a-zA-Z ]*$"));
    }
}
