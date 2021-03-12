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

    public List<String> topKFrequentHeapApproach(String[] words, int k){
        /*
        * Approach taken:
        * 1. We make use of our hash map HM, to keep track of words and their frequency;
        * 2. for each word in the WORDS and its count , we add it to the HM
        * 3. Initialize our PriorityQueue(max heap) PQ.
        * 4. We add all our values in HM to PQ.
        * 5. while adding values from HM to PQ:
        *       a. if PQ.size is equal to k then we poll PQ
        * 6. After adding values to PQ, then we poll each item to a list LI
        * 7. Reverse LI
        *
        * Time Complexity: O(N log k), where N is the length of words. We count the frequency of each word in O(N) time,
        *  then we add N words to the heap, each in O(log k) time.
        * Finally, we pop from the heap up to k times. As k ≤ N, this is O(N log k) in total.
        *
        * Space Complexity: O(N), the space used to store our count.
        * */

        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new WordCountComparator(wordCountMap));

        for (String word :wordCountMap.keySet()) {
            priorityQueue.add(word);
            if(priorityQueue.size() > k) priorityQueue.poll();
        }

        List<String> topFrequentList = new ArrayList<>();
        while (!priorityQueue.isEmpty()) topFrequentList.add(priorityQueue.poll());
        Collections.reverse(topFrequentList);
        return topFrequentList;
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
