package com.jworks.stringpractice;

import java.util.Arrays;

public class StringPractice4 {

    /*
    * Question
    *  Given two strings, write a method to decide if one is a permutation of the other
    * */


    public static boolean isPalindrome(String one, String two){
        if(one.length() != two.length()){
            return false;
        }
        return sort(one).equals(sort(two));
    }

    private static String sort(String value){
        char[] sortedValue = value.toCharArray();
        Arrays.sort(sortedValue);
        return new String(sortedValue);
    }
}
