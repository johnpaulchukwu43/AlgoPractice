package com.jworks.dynamicprogramming;

import java.util.Arrays;

public class DynamicProgrammingPractice2 {
    private int counter = 0;

    /*
     * Given an integer array nums, find the contiguous subarray
     *  (containing at least one number) which has the largest sum and return its sum
     * */
    public static void main(String[] args) {
        // write your code here

        System.out.println(new DynamicProgrammingPractice2().maxSubArrayMergeSortApproach(new int[]{5, 4, -1, 7, 8}));
    }


    public int maxSubArrayMergeSortApproach(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }

    private int crossSum(int[] nums, int left, int right, int mid) {
        System.out.println(String.format("Doing cross sum At iteration: %s", counter));
        System.out.println(String.format("crossSum(%s,%s)", left, right));
        System.out.println(String.format("mid: %s", mid));
        System.out.println(String.format("nums: %s", Arrays.toString(nums)));
        if (left == right) return nums[left];

        int leftSubSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = mid; i > left - 1; --i) {
            currSum += nums[i];
            leftSubSum = Math.max(leftSubSum, currSum);
        }
        System.out.println(String.format("leftSubSum: %s", leftSubSum));

        int rightSubSum = Integer.MIN_VALUE;
        currSum = 0;
        for (int i = mid + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubSum = Math.max(rightSubSum, currSum);
        }
        System.out.println(String.format("rightSubSum: %s", rightSubSum));
        System.out.println("------/---/----/------/----/---");
        return leftSubSum + rightSubSum;
    }

    private int helper(int[] nums, int left, int right) {
        System.out.println(String.format("At iteration: %s", counter++));
        System.out.println(String.format("helper(%s,%s)", left, right));
        System.out.println("--------------------------");
        if (left == right) return nums[left];

        int mid = (left + right) / 2;
        System.out.println(String.format("mid: %s", mid));

        int leftSum = helper(nums, left, mid);
        int rightSum = helper(nums, mid + 1, right);
        int crossSum = crossSum(nums, left, right, mid);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
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

        if (nums.length < 2) return nums.length;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {

                int temp = getSumOfSubArray(Arrays.copyOfRange(nums, i, j + 1));
                if (temp > maxSumOfSubArray) maxSumOfSubArray = temp;
            }
        }

        return maxSumOfSubArray;
    }

    private int getSumOfSubArray(int[] subArray) {
        int sum = 0;
        for (int j : subArray) {
            sum += j;
        }

        return sum;
    }


}
