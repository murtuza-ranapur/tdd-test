package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    public static StringCalculator stringCalculator;

    @BeforeAll
    static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    public void add_emptyInput_pass(){
        int expected = 0;
        String input = "";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_singleInput_pass(){
        int expected = 1;
        String input = "1";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_twoInput_pass(){
        int expected = 3;
        String input = "1,2";
        assertEquals(expected, stringCalculator.add(input));
    }
}