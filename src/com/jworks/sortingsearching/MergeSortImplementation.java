package com.jworks.sortingsearching;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

public class MergeSortImplementation {


    /*
    * Uses Divide & Conquer apprach
    * 1. We divide the array to sub arrays until
    * 2.
    * 3.
    *
    *
    * */

    public static void main(String[] args) {
        // write your code here
        int[] nums = {10, 2, 5, 22, 4};
        new MergeSortImplementation().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] valuesToBeSorted){
        int length = valuesToBeSorted.length - 1;
        if( length < 2) return;

        divide(valuesToBeSorted,0,length);
    }

    public void divide(int[] valuesToBeSorted, int lowerBound, int upperBound){

        if (lowerBound < upperBound){

            int mid = lowerBound + upperBound /2;

            divide(valuesToBeSorted,lowerBound,mid);
            divide(valuesToBeSorted,mid+1,upperBound);
            merge(valuesToBeSorted,lowerBound,mid+1,upperBound);
        }
    }

    private void merge(int[] valuesToBeSorted, int lowerBound, int mid, int upperBound) {

        int R1 = lowerBound;
        int R2 = mid;

        int W1 = lowerBound;

        int [] sortedArray = new int[valuesToBeSorted.length];

        while (R1 <= mid && R2 <= upperBound){
            if(valuesToBeSorted[R1] <= valuesToBeSorted[R2]){
                sortedArray[W1++] = valuesToBeSorted[R1++];
            }else{
                sortedArray[W1++] = valuesToBeSorted[R2++];
            }
        }

        if(R1 > mid){
            while (R2<=upperBound){
                sortedArray[W1++] = valuesToBeSorted[R2++];
            }
        }else{
            while (R1 < mid){
                sortedArray[W1++] = valuesToBeSorted[R1++];
            }
        }

        for(int i=upperBound; i >=lowerBound ; i--)
        {
            valuesToBeSorted[i] = sortedArray[--W1];  // copying back the sorted list to a[]
        }

    }



}
