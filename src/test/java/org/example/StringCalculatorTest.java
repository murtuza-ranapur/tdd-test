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
    public void add_emptyInput_positive(){
        int expected = 0;
        String input = "";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_singleInput_positive(){
        int expected = 1;
        String input = "1";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_twoInput_positive(){
        int expected = 3;
        String input = "1,2";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_multiInput_positive(){
        int expected = 10;
        String input = "1,2,3,4";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_multiInputWithNewLine_positive(){
        int expected = 10;
        String input = "1\n2,3\n4";
        assertEquals(expected, stringCalculator.add(input));
    }

    @Test
    public void add_multiInputWithCustomDelimiter_positive(){
        int expected = 10;
        String inputCase1 = "//;\n1;2;3;4";
        String inputCase2 = "//;\n1;2;3\n4";
        String inputCase3 = "//;\n10";
        String inputCase4 = "//;\n";
        assertEquals(expected, stringCalculator.add(inputCase1));
        assertEquals(expected, stringCalculator.add(inputCase2));
        assertEquals(expected, stringCalculator.add(inputCase3));
        assertEquals(0, stringCalculator.add(inputCase4));
    }

    @Test
    public void add_negativeInteger_negative(){
        String inputCase1 = "1,2,-3,4";
        assertThrows(NumberOutOfRangeException.class, ()->{
            stringCalculator.add(inputCase1);
        });
    }
    
}