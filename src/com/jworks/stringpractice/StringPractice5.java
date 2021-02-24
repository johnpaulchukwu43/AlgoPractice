package com.jworks.stringpractice;

import java.util.HashMap;

public class StringPractice5 {

/* Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.
 *
  * Approach:
  *  We go through each char and store its count in a hashmap . Then retrieve the char with the first occurrence in the hashmap
  *
  * */

    public static int firstUniqChar(String word) {

        char[] wordCharList = word.toCharArray();

        HashMap<Character,Integer> characterCountMap = new HashMap<>();
        for (int i = 0; i < wordCharList.length; i++) {

            characterCountMap.put(wordCharList[i],characterCountMap.getOrDefault(wordCharList[i],0) + 1);
        }

        for (int i = 0; i < wordCharList.length; i++) {

            if(characterCountMap.get(wordCharList[i]) == 1){
                return i;
            }
        }

        return -1;
    }
}
