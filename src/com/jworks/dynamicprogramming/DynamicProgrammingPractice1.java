package com.jworks.dynamicprogramming;

public class DynamicProgrammingPractice1 {

   /* Given a string s, return the longest palindromic substring in s.*/



    public String longestPalindromeNaiveApproach(String word) {

        /*
        * Approach Taken:
        *
        * 1. If the length of the word is zero, just return or if it is one return the character
        * 2. Create variable to hold largest palindrome LP
        * 3. Go through the word, for each character CH:
        *    a. get all the possible substring combinations, at each stage check for
        *       which one of them is a palindrome and for every palindrome found check if its the largest palindrome
        *       and as assign to LP
        * 4. Return LP
        *
         * Very Naive Approach as
         * Time Complexity = O(N^3) Wahala o !!
         * Space Complexity = 0(1)
        * */

        if(word.length() <= 1) return word;

        String largestPalindrome = "";

        for (int i = 0; i < word.length(); i++) {

            for (int j = i; j < word.length(); j++) {
                String currentSubstring = word.substring(i, j+1);
                if(isPalindrome(currentSubstring) && currentSubstring.length() > largestPalindrome.length()){
                    largestPalindrome = currentSubstring;
                };
            }
        }

        return largestPalindrome;
    }

    private boolean isPalindrome(String substring){
        StringBuilder reverseSubstringBuilder = new StringBuilder();
        char[] substringCharArray = substring.toCharArray();
        for (int i = substringCharArray.length - 1; i >= 0; i--) {
            reverseSubstringBuilder.append(substringCharArray[i]);
        }
        return (reverseSubstringBuilder.toString()).equals(substring);
    }

}
