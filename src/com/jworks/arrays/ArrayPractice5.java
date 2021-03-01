package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice5 {

/*
    Question:
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
    Input: nums = [3,2,2,3], val = 3
    Output: 2, nums = [2,2]
    */

    public static void main(String[] args) {
        // write your code here
        int [] nums = new int[]{3,2,2,3};
        System.out.println(Arrays.toString(removeElement(nums, 3)));
    }


    public static int[] removeElement(int[] nums, int val) {
        /*
        * Approach:
        *   1.We make use of two cursors; Fast and slow;
        *   2.initialize slow to 0 and fast to 0
        *   3. check if nums[slow] is not equals to val then
        *       a. assign nums[slow] to nums[fast]
        *       b. increment fast by 1
        *      else:
        *       just continue
        */
        int fast = 0;
        for (int slow = 0; slow <nums.length; slow++) {
            if(nums[slow] != val){
                nums[fast] = nums[slow];
                fast++;
            }
        }

        return nums;
    }
}
