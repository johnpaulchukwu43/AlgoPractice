package com.jworks;

import java.util.HashMap;
import java.util.Map;

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

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {

                if ((nums[i] + nums[j + 1]) == target)
                    return new int[]{i,j+1};
            }
        }

        throw new IllegalArgumentException("None of the pairs sum to the target");
    }

    private static int[] twoSumOptimizedApproach(int[] nums, int target) {

        /*
        * Here we lop through once and use a hashMap to store the possible complements.
        * Complement  =  target - x, where x is a number in the list.
        * At the same time we perform a lookup to see if any complements our target.
        * By so doing,complexity of becomes o(1). Thanks to our HashMap ;)
        * */

        Map<Integer,Integer> complementsAndPositionMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(complementsAndPositionMap.containsKey(complement)){

                return new int[]{complementsAndPositionMap.get(complement), i};
            }

            complementsAndPositionMap.put(nums[i],i);
        }

        throw new IllegalArgumentException("None of the pairs sum to the target");
    }

}
