package com.jworks.arrays;

/**
 * @author Johnpaul Chukwu.
 * @since 01/03/2021
 */
public class ArrayPractice7 {

/*    Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the        last element with -1.
    After doing so, return the array.

    Input: arr = [17,18,5,4,6,1]
    Output: [18,6,6,6,1,-1]

    Input: arr = [400]
    Output: [-1]

*/


    public int[] replaceElements(int[] arr) {

        int lastPos = arr.length - 1;

        int prevVal = 0;
        int maxVal = 0;

        for (int i = lastPos; i >= 0; i--) {
            if(i == lastPos){
                prevVal = arr[i];
                maxVal = arr[i];
            }else if(prevVal >= maxVal){
                maxVal = prevVal;
                prevVal = arr[i];

                arr[i] = maxVal;

                if(prevVal >= maxVal){
                    maxVal = prevVal;
                }
            }else{
                prevVal = arr[i];
                arr[i] = maxVal;
            }
        }

        return arr;
    }
}
