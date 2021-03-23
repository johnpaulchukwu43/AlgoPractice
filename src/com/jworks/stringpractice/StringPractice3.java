package com.jworks.stringpractice;

import java.util.HashSet;

import static com.jworks.stringpractice.StringPractice1.isUniqueCharacterString;

public class StringPractice3 {

//    Given a string s, find the length of the longest substring without repeating characters. "pwwkew"

    public static void main(String[] args) {
        // write your code here

        System.out.println(lengthOfLongestSubstringSlidingWindowApproach("abcabcbb"));
    }


    public static int lengthOfLongestSubstringBruteForceApproach(String input) {

        /*
        * A naive approach; we loop through every char and get all possible substring.
        * For each substring gotten we check if they have a unique characters.
        * If so, then we assign the length of the current substring as the largest unique substring until a longer unique one is found
        * Time complexity for this would be O(n3) .. Omo !!!!!
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

    public static int lengthOfLongestSubstringSlidingWindowApproach(String input) {

        /*
        *
        * So for this approach we make use of:
        * 1. Two pointers  R1 , R2
        *
        * 2. Hashset HS to keep track of distinct characters
        *
        * 3. Var Max to keep track of max count.
        *
        * 4. We set R1, R2 to start at the beginning of the string
        *
        * 5. While looping through the string input:
        *   a. Check does HS contain charAt position R2
        *   b. if it doesn't  then add  charAt position R2 to HS and increment R2 and  set Max to the bigger value of the size of HS and current MAX
        *   c. Else, remove charAt position R1 in HS, and increment R1
        *
        *
        * */

        int R1 = 0;
        int R2 = 0;
        int max = 0;

        HashSet<Character> hashSet = new HashSet<>();

        while (R2< input.length()){

            if(!hashSet.contains(input.charAt(R2))){
                hashSet.add(input.charAt(R2));
                max = Math.max(hashSet.size(),max);
                R2++;
            }else{

                hashSet.remove(input.charAt(R1));
                R1++;

            }

        }


        return max;

    }

}
