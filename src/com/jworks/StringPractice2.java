package com.jworks;

import java.util.Arrays;

public class StringPractice2 {

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Input: nums = [3,6,7,100,11,15], target = 9
*/



    public static int[] twoSumBruteForceApproach(int[] nums, int target) {

        /*
        * This approach uses a brute force technique by trying to get all possible pairs that sum to the target.
        * Works fine but has complexity of o(n2), not so ideal ;(
        * */

        for (int num : nums) {
            for (int j = 0; j < nums.length; j++) {

                if ((num + nums[j + 1]) == target)
                    return new int[]{num, nums[j + 1]};
            }
        }

        return new int[]{};
    }

}
