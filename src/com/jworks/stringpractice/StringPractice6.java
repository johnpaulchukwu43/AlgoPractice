package com.jworks.stringpractice;

import java.util.Arrays;

/**
 * @author Johnpaul Chukwu.
 * @since 24/02/2021
 */
public class StringPractice6 {

/*
    Question:
    Write a method to replace all spaces in a string with'%20'. You may assume that the string has
    sufficient space at the end of the string to hold the additional characters, and that you are given the "true" length of the string.
    (Note: if implementing in Java, please use a character array so that you can perform this opera- tion in place.)

    Approach taken:
    1) In a single pass, Get the number of spaces in string.
    2) Calculate the expected length of the string i.e. with number of space included.
    3) In another pass, but this time in reverse order, replace (performed inplace) the space with with'%20'
 */

    public static String replaceEmptySpace(String word, int trueLength){

        int spaceCount = 0;

        char[] wordCharList = word.toCharArray();

        for (int i = 0; i < trueLength; i++) {
            if (wordCharList[i] == ' '){
                spaceCount++;
            }
        }

        int expectedLength = trueLength + spaceCount*2;

        wordCharList[expectedLength] = '\0';

        for (int i = trueLength-1; i >=0; i --) {
            if(wordCharList[i] == ' '){
                wordCharList[expectedLength-1] = '0';
                wordCharList[expectedLength-2] = '2';
                wordCharList[expectedLength-3] = '%';
                expectedLength = expectedLength -3;
            }else{
                wordCharList[expectedLength-1] = wordCharList[i];
                expectedLength = expectedLength -1;
            }

        }

        return Arrays.toString(wordCharList);
    }
}
