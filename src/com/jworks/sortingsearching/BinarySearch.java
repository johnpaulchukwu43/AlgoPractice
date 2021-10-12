package com.jworks.sortingsearching;


/**
 * @author Johnpaul Chukwu.
 * @since 12/10/2021
 */
public class BinarySearch {

    /*
    * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

        You must write an algorithm with O(log n) runtime complexity.
    *
    *
    * */

    public static int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {

        if (left > right) return -1;


        int middle = left + (right - left) / 2;

        if (nums[middle] == target) return middle;

        if (target > nums[middle])
            return binarySearch(nums, target, middle + 1, right);

        return binarySearch(nums, target, left, middle - 1);
    }

    public static void main(String[] args) {
        // sample run
        int [] nums = new int[]{3,2,2,3,5,10,20,50};
        System.out.println(search(nums,3));
    }

}
