package com.jworks.stringpractice;

import static com.jworks.stringpractice.StringPractice1.isUniqueCharacterString;

public class StringPractice3 {

//    Given a string s, find the length of the longest substring without repeating characters. "pwwkew"


    public static int lengthOfLongestSubstringBruteForceApproach(String input) {

        /*
        * A naive approach; we loop through every char and get all possible substring.
        * For each substring gotten we check if they have a unique characters.
        * If so, then we assign the length of the current substring as the largest unique substring until a longer unique one is found
        * */

        int length = input.length();

        if(length == 0) return 0;

        int longestSubString = 0;

        for (int i = 0; i < length; i++) {

            for (int j = i; j < length; j++) {
                String substring = input.substring(i, j+1);
                boolean uniqueCharacterString = isUniqueCharacterString(substring);
                if(uniqueCharacterString && longestSubString < substring.length()){
                    longestSubString = substring.length();
                }
            }
        }

        return longestSubString;
    }

}
