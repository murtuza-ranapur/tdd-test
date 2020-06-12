package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",";
    private static final int THRESHOLD = 1000;
    private static final Pattern pattern = Pattern.compile("\\[([^\\[\\]]+)\\]");

    private int count;
    /**
     * Takes input in form of String. Adds multiple numbers.
     * Sample input "1,2". Sequence of numbers should be
     * separated by "," or "\n" newline.
     *
     * You can also provide your own delimiter by following this given
     * standard. '//[delimiter]\n[numbers]' e.g., //;\n1;2
     *
     * If want to provide variable length delimiter use the following format
     * '//[delimiter]\n[numbers]' e.g., //[;;]\n1;;2
     *
     * @param numbers String sequence of numbers
     * @return integer sum of given numbers
     */
    public int add(String numbers) {
        int sum = 0;
        count++;
        String delimiter = DEFAULT_DELIMITER;
        if(numbers.startsWith("//")){
            String [] temp = numbers.split("\n", 2);
            delimiter = getDelimiter(temp[0]);
            numbers = temp[1];
        }
        String splitRegex = delimiter+"|\n";
        if(numbers.isEmpty())
            return 0;
        String [] nums = numbers.split(splitRegex);
        List<Integer> negatives = new ArrayList<>();
        for (String num : nums) {
            int i = Integer.parseInt(num);
            if(i < 0) {
                negatives.add(i);
                continue;
            } else if(i > THRESHOLD){
                continue;
            }
            sum += i;
        }
        String negativeNums = negatives.stream().map(a -> ""+a).collect(Collectors.joining(","));
        if(negatives.size() > 0){
            throw new NumberOutOfRangeException("Negatives not allowed :"+negativeNums);
        }
        return sum;
    }

    private String getDelimiter(String s) {
        Matcher matcher = pattern.matcher(s);
        List<String> delimiters = new ArrayList<>();
        while (matcher.find()){
            delimiters.add(matcher.group(1));
        }
        if(delimiters.size() > 0){
            return delimiters.stream().map(this::escapeCharacter).collect(Collectors.joining("|"));
        }
        return escapeCharacter(s.substring(2,3));
    }

    private String escapeCharacter(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append("\\");
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public int getCalledCount(){
        return count;
    }

}
