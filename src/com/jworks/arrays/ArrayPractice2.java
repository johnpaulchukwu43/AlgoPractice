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
}
