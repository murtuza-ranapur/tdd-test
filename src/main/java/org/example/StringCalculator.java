package org.example;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",";

    /**
     * Takes input in form of String. Adds multiple numbers.
     * Sample input "1,2". Sequence of numbers should be
     * separated by "," or "\n" newline.
     *
     * You can also provide your own delimiter by following this given
     * standard. '//[delimiter]\n[numbers]' e.g., //;\n1;2
     *
     * @param numbers String sequence of numbers
     * @return integer sum of given numbers
     */
    public int add(String numbers) {
        int sum = 0;
        String delimiter = DEFAULT_DELIMITER;
        if(numbers.startsWith("//")){
            String [] temp = numbers.split("\n", 2);
            delimiter = temp[0].substring(2,3);
            numbers = temp[1];
        }
        String splitRegex = "["+delimiter+"\n]";
        if(numbers.isEmpty())
            return 0;
        String [] nums = numbers.split(splitRegex);
        List<Integer> negatives = new ArrayList<>();
        for (String num : nums) {
            int i = Integer.parseInt(num);
            if(i < 0) {
                negatives.add(i);
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

}
