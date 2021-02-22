package com.jworks.stringpractice;

/*
        Question1
    Implement an algorithm to determine if a string has all unique characters. What
    if you cannot use additional data structures?
 */

public class StringPractice1 {

    public static boolean isUniqueCharacterString(String input){

        int inputLength = input.length();
        //Assuming the characters are ASCII then there are 256 possible values
        if( inputLength> 256){
            return false;
        }

        boolean[] input_array = new boolean[256];

        for (int i = 0; i < inputLength; i++) {

            int charInput = input.charAt(i);
            if(input_array[charInput]){
                return false;
            }

            input_array[charInput] = true;
        }
        return true;
    }
}
