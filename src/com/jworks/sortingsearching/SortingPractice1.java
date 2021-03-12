package com.jworks.sortingsearching;


import com.jworks.Playground;

import java.util.*;

public class SortingPractice1 {

/*
    Given a non-empty list of words, return the k most frequent elements.
    Your answer should be sorted by frequency from highest to lowest.
    If two words have the same frequency, then the word with the lower
    alphabetical order comes first.

    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    Output: ["i", "love"]
    Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
 */

    public static void main(String[] args) {

        String[] words = new String[]{ "i", "love", "leetcode", "i", "love", "coding"} ;
        String[] words2 = new String[]{ "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"} ;
        System.out.println(new SortingPractice1().topKFrequentSortingApproach(words,2));

    }

    public List<String> topKFrequentSortingApproach(String[] words, int k) {

        /*
        * Approach taken:
        * 1. We make use of our hash map HM, to keep track of words and their frequency;
        * 2. for each word in the WORDS and its count , we add it to the HM
        * 3. sort HM by count in descending order to get the K frequent word.
        * Time Complexity: O(NlogN), where N is the length of words.
        * We count the frequency of each word in O(N) time, then we sort the given words in O(NlogN) time.
          Space Complexity: O(N), the space used to store our candidates.
        * */

        Map<String,Integer> wordCountMap = new HashMap();

        for (String word : words) {
            wordCountMap.put(word,wordCountMap.getOrDefault(word, 0) + 1);
        }

        List<String> sortedWordList = new ArrayList<>(wordCountMap.keySet());

        sortedWordList.sort(new WordCountComparator(wordCountMap));

        return sortedWordList.subList(0,k);

    }


    static class WordCountComparator implements Comparator<String>{

        private final Map<String,Integer> wordCountMap;

        public WordCountComparator(Map<String, Integer> wordCountMap) {
            this.wordCountMap = wordCountMap;
        }

        @Override
        public int compare(String w1, String w2) {
            return wordCountMap.get(w1).equals(wordCountMap.get(w2)) ?
                    w1.compareTo(w2) : wordCountMap.get(w2) - wordCountMap.get(w1);
        }
    }

}
