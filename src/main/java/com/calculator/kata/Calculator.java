package com.calculator.kata;

import java.util.regex.Pattern;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        
        String[] nums = parseNumbers(numbers);
        int sum = 0;
        
        try {
            for (String num : nums) {
                int val = Integer.parseInt(num.trim());
                if(val > 1000) continue;
                sum += val;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input: all parts must be integers.");
        }

        return sum;
    }

    private String[] parseNumbers(String numbers) {
        if (numbers.startsWith("//")) {
            int newlineIndex = numbers.indexOf("\n");
            String customDelimiter = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1);
            String numberSeparators = Pattern.quote(customDelimiter) + "|,|\n";
            return numbers.split(numberSeparators);
        } else {
            return numbers.split(",|\n");
        }
    }
}
