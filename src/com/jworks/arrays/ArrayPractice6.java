package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice6 {

/*    Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory

    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4]
*/
public static void main(String[] args) {
    // write your code here
    int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    System.out.println(Arrays.toString(removeDuplicates(nums)));
}


    public static int[] removeDuplicates(int[] nums) {

        if (nums.length == 0) return new int[]{0};
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return nums;
    }

}
