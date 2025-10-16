package com.calculator.kata;

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
                sum += Integer.parseInt(num.trim());
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
            return numbers.split(customDelimiter + "|,|\n");
        } else {
            return numbers.split(",|\n");
        }
    }
}
