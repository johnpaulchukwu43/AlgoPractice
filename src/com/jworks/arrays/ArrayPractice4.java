package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice4 {

/*
    Question:
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has a size equal to m + n such that it has enough space to hold additional elements from nums2.

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 [1,2,3,0,0,0]
    Output: [1,2,2,3,5,6]
    */

    public static void main(String[] args) {
        // write your code here

        System.out.println(Arrays.toString(moreOptimalMergeApproach(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));

    }

    public static int[] naiveApproachMerge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = m; i < m + n; i++) {

            nums1[i] = nums2[i-n];
        }

        Arrays.sort(nums1);

        return nums1;
    }
    
    public static int[] moreOptimalMergeApproach(int[] nums1, int m, int[] nums2, int n) {
        
        /*
            Approach taken:
            1. Create a copy of nums1 as nums1Copy
            2. Create a read cursor R1 , and point to begin of nums1Copy
            3. Create a read cursor R2, and point to begin of nums2
            4. Create a write pointer W1 and point to begin of nums1
            5. While W1 is still within nums1 length, check:
                i. if nums1Copy [R1] exists and is less than or equal to nums2[R2]:
                        write nums1Copy [R1] into nums1[W1], increment R1
                    else:
                        write nums2 [R2] into nums1[W1], increment R2
                ii. increment W2
        */
        
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }
        
        int R1 = 0;
        int R2 = 0;
    
        for(int w1 = 0; w1< m+n;w1++){
            
            if(R2 >= n || (R1<m && nums1Copy[R1] < nums2[R2])){
                nums1[w1] = nums1Copy[R1++];
            }else{
                nums1[w1] = nums2[R2++];
            }
        }
        return nums1;
    }

    public static int[] mostOptimalMergeApproach(int[] nums1, int m, int[] nums2, int n){
         /*
          Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6]
            Approach taken:
            1.  Create a read cursor R1, and point to m -1
            2.  Create a read cursor R2, and point to n-1
            3.  Create a write pointer W1 and point to end of m+n-1
            4.  While W1 is still within nums1 length, check:
                i. if nums2.length is greater than 0 and nums2[R2] > nums1[R1]:
                    write nums1[W1] = nums2[R2]
                   else:
                     write nums1[W1] = nums2[R1]
        */
        int R1 = m-1;
        int R2 = n-1;

        for (int W1 = 0; W1 < m + n - 1; W1++) {

            if(R2 < 0){
                break;
            }

            if(R1 > 0 && nums1[R1] > nums2[R2]){
                nums1[W1] = nums1[R1--];
            }else{
                nums1[W1] = nums2[R2--];
            }
        }

        return nums1;


    }
}
