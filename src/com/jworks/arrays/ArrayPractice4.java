package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice4 {

/*
    Question:
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]
    */


    public static int[] naiveApproachMerge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m; i < m + n; i++) {

            nums1[i] = nums2[i-n];
        }

        Arrays.sort(nums1);

        return nums1;
    }
}
