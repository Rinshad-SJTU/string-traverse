package com.bipo.interview.bipointerview;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Traverse {

    private int sumOfNumbers = 0, totalLetters;
    private float result;

    public String NumberSearch(String str) {

        //calculate the sum of single digit numbers in the string
        Matcher matcher = Pattern.compile("(?<!\\d)\\d(?!\\d)").matcher(str);

        while (matcher.find()) {
            sumOfNumbers += Integer.parseInt(matcher.group());
        }

        if (sumOfNumbers == 0) {
            return "No single digit number separated by spaces found!";
        } else {

            //find the total number of letters in the string
            totalLetters = str.replaceAll("[.^\\s\\d\\W]+", "").length();

            //final result
            result = Math.round((float) sumOfNumbers / (float) totalLetters);
        }

        //reset
        sumOfNumbers = 0;

        return String.format ("%.0f", result);
    }
}
