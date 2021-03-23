package com.jworks.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class DesignPractice1 {

/*   Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:

    LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
    int get(int key) Return the value of the key if the key exists, otherwise return -1.
    void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    Follow up:
    Could you do get and put in O(1) time complexity?


    My thoughts:
    LRU cache is a caching mechanism that organizes items in their order of use, where the least used item in the cache appears at the bottom
    & vice Versa.

    LRU Eviction: Due to the fact, we can't hold everything in the cache how do we determine what cache should hold ?
    The LRU cache works on the principle that the least used item in the cache (expected to be at the bottom of the cache)
    would be evicted whenever the cache is full and a new item is to be added.

    We are asked to implement a structure that provides 0(1) time for get, and put and also allow removal from the cache
    based on the LRU principle explained earlier.

    So using a Hashmap allows us to get, and put items in 0(1), together with a LinkedList would allow us remove items at the bottom
    of the list in 0(1)



    */

    class LRUCache extends LinkedHashMap<Integer,Integer> {

        /*
        * A LinkedHashMap uses a HashMap & Doubly LinkedList under the hoods, hence making it ideal for LRU design needed.
        * */

        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75f,false);
            this.capacity =capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key,-1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
