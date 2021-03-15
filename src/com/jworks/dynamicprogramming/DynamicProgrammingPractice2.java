package com.jworks.dynamicprogramming;

import java.util.Arrays;

public class DynamicProgrammingPractice2 {

    /*
    * Given an integer array nums, find the contiguous subarray
    *  (containing at least one number) which has the largest sum and return its sum
    * */
    public static void main(String[] args) {
        // write your code here

        System.out.println(new DynamicProgrammingPractice2().maxSubArrayNaiveApproach(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArrayNaiveApproach(int[] nums) {
        int maxSumOfSubArray = 0;

        /*
        * Approach Taken:
        * 1. Declare var MAX_SUB_ARRAY
        * 2. For array NUMS, for every element NUM:
        *   a. Find all possible combinations for NUM, for each combination found:
        *      i. Sum the value of elements in the combination
        *      ii. check if the sum Sum the value of elements in the combination is grater than MAX_SUB_ARRAY
        *       if so then set MAX_SUB_ARRAY to that value.
        *
        * Very Naive solution because:
        * Time complexity: 0(N^3)
        * Space Complexity: 0(n)
        * */

        if(nums.length < 2) return nums.length;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                int temp = getSumOfSubArray(Arrays.copyOfRange(nums,i,j+1));
                if(temp > maxSumOfSubArray) maxSumOfSubArray = temp;
            }
        }

        return maxSumOfSubArray;
    }

    private int getSumOfSubArray(int[] subArray){
        int sum = 0;
        for (int j : subArray) {
            sum += j;
        }

        return sum;
    }


}
