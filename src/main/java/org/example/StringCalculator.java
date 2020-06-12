package org.example;

public class StringCalculator {

    /**
     * Takes input in form of String. Adds multiple numbers.
     * Sample input "1,2". Sequence of numbers should be
     * separated by "," or "\n" newline.
     *
     * @param numbers String sequence of numbers
     * @return integer sum of given numbers
     */
    public int add(String numbers) {
        int sum = 0;
        if(numbers.isEmpty())
            return 0;
        String [] nums = numbers.split("[,\n]");
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}
