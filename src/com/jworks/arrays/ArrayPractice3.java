package com.jworks.arrays;

import java.util.Arrays;

public class ArrayPractice3 {

    /*
        Question:
        Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

        Note that elements beyond the length of the original array are not written.

        Do the above modifications to the input array in place, do not return anything from your function

        Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

        Approach:
        1. Get length as length of array -1
        2.  loop through array and identify the number of elements that would be discarded; totalElementToDiscard, simply by checking the number of 0.
        3. To loop through, we continue looping until our counter is equal to (length - totalElementToDiscard), while increasing our totalElementToDiscard when O is encountered.
        4. loop through array in reverse order, starting from the lastPos: which is defined as (length - totalElementToDiscard)
            if current position;currentPosition  is equal to 0
                a.set the position [totalElementToDiscard + currentPosition] to 0
                b.decrement totalElementToDiscard
                c.Again, set the position [totalElementToDiscard + currentPosition] to 0
             else
                set the position [totalElementToDiscard + currentPosition] = currentValue
    */



    public static int[] duplicateZeros(int[] arr) {


        int length = arr.length - 1;

        int totalElementToDiscard = 0;

        for (int i = 0; i < length - totalElementToDiscard; i++) {

            if(arr[i] == 0){
                /*  To handle edge case where last element after removing the ones to be discarded is zero.
                    For this there would be no space to duplicate another zero despite the last element being zero.
                 */
                if (i == length - totalElementToDiscard) {
                    // For this zero we just copy it without duplication.
                    arr[length] = 0;
                    length -= 1;
                    break;
                }

                totalElementToDiscard++;
            }
        }

        int lastPos = length - totalElementToDiscard;
        for (int i = lastPos; i>=0 ; i--) {

            if(arr[i] == 0){
                arr[totalElementToDiscard + i] = 0;
                totalElementToDiscard--;
                arr[totalElementToDiscard + i] = 0;
            }else{
                arr[totalElementToDiscard + i] = arr[i];
            }
        }

        return arr;
    }

}
