package com.calculator.kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest
{
    private static Calculator calculator;
    
    @BeforeAll
    public static void setup()
    {
        calculator = new Calculator();
    }
    
    @Test
    public void shouldReturnZeroOnEmptyString()
    {
         int res = calculator.add("");
         assertEquals(0, res);
    }
    
    @Test
    public void shouldReturnNumberWhenSingleNumberIsGiven()
    {
        int res = calculator.add("5");
        assertEquals(5, res);
    }
    
    @Test
    public void shouldReturnSumWhenTwoNumbersAreGiven()
    {
        int res = calculator.add("1,2");
        assertEquals(3, res);
    }
    
    @Test
    public void shouldReturnSumWhenMultipleNumbersAreGiven()
    {
        int res = calculator.add("1,2,3,4,5");
        assertEquals(15, res);
    }
    
    @Test
    public void shouldReturnSumOfDigitsWhenNewLinesArePassed()
    {
        int res = calculator.add("1\n2,3");
        assertEquals(6, res);

        int res2 = calculator.add("3\n2,3\n5");
        assertEquals(13, res2);
    }
    
    @Test
    public void shouldReturnSumWhenDifferentDelimitersArePassed()
    {
        int res = calculator.add("//;\n1;2");
        assertEquals(3, res);
        
        int res3 = calculator.add("//%\n2%3");
        assertEquals(5, res3);
    }
    
    @Test
    public void shouldThrowErrorWhenInvalidInputIsGiven()
    {
        try {
            calculator.add("1,\n");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input: all parts must be integers.", e.getMessage());
        }
        
        try {
            calculator.add("1,X");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input: all parts must be integers.", e.getMessage());
        }
    }
    
}
