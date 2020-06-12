package org.example;

public class StringCalculator {

    /**
     * Takes input in form of String. Adds upto two numbers.
     * Sample input "1,2". Sequence of numbers separated by ",".
     *
     * @param numbers String sequence of numbers
     * @return integer sum of given numbers
     */
    public int add(String numbers) {
        if(numbers.isEmpty())
            return 0;
        String [] nums = numbers.split(",");
        if(nums.length == 1){
            return Integer.parseInt(nums[0]);
        }
        return Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
    }
}
