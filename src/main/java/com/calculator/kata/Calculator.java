package com.calculator.kata;

public class Calculator
{
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        
        if (numbers.contains(",")) {
            String[] nums = numbers.split(",|\n");
            int sum = 0;
            for (String num : nums) {
                sum += Integer.parseInt(num);
            }
            return sum;
        }
        return Integer.parseInt(numbers);
    }
}
