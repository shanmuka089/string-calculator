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
}
