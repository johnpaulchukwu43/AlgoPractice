package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice2 {

/*
    Question:
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
*/



    public static int[] sortedSquaresNaiveApproach(int[] numArray) {
        int length = numArray.length;
        int[] squaredArray = new int[length];

        for (int i = 0; i < length; i++) {
            squaredArray[i] = numArray[i] * numArray[i];
        }

         Arrays.sort(squaredArray);
        return squaredArray;
    }

    public static int[] sortedSquaresOptimalApproach(int[] numArray) {
        int length = numArray.length;

        int[] squaredArray = new int[length];

        int leftPointer = 0;
        int rightPointer = length -1;

        for (int i = length -1; i >=0; i--) {
            int squared;
            if(Math.abs(numArray[leftPointer]) > Math.abs(numArray[rightPointer])){
                squared = numArray[leftPointer] * numArray[leftPointer];
                leftPointer +=1;
            }else{
                squared = numArray[rightPointer] * numArray[rightPointer];
                rightPointer -=1;
            }

            squaredArray[i] = squared;
        }
        return squaredArray;
    }
}
