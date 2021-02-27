package com.jworks.arrays;

public class ArrayPractice1 {

    /*
    Question:
    Given a binary array, find the maximum number of consecutive 1s in this array.
    */

    public int findMaxConsecutiveOnes(int[] nums) {
        int longestCounter = 0;
        int counter = 0;
        for (int num : nums) {

            if (num == 1) {
                counter++;
            } else {

                longestCounter = Math.max(longestCounter, counter);
                counter = 0;
            }
        }

        return Math.max(longestCounter, counter);
    }
}
