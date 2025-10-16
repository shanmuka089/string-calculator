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
                if(val < 0) {
                    throw new IllegalArgumentException("Negatives values not allowed: " + val);
                }
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
            
            if(newlineIndex == -1) {
                throw new IllegalArgumentException("Invalid input: missing newline after custom delimiter.");
            }
            
            String delimiterSection = numbers.substring(2, newlineIndex);
            numbers = numbers.substring(newlineIndex + 1);
            
            String splittingPattern = fetchSplittingPattern(delimiterSection);
            return numbers.split(splittingPattern);
        } else {
            return numbers.split(",|\n");
        }
    }

    private static String fetchSplittingPattern(String delimiterSection)
    {

        String splittingPattern;
        if (delimiterSection.startsWith("[") && delimiterSection.endsWith("]")) {
            String[] delimiters = delimiterSection.substring(1, delimiterSection.length() - 1).split("]\\[");
            StringBuilder regexBuilder = new StringBuilder();
            for (String delimiter : delimiters) {
                regexBuilder.append(Pattern.quote(delimiter)).append("|");
            }
            splittingPattern = regexBuilder.append(",|\n").toString();
        } else {
            splittingPattern = Pattern.quote(delimiterSection) + "|,|\n";
        }
        return splittingPattern;
    }

}
