import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Created by S N Rao on 3/23/2017.
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it
 * should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when
 * there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LFUCache cache = new LFUCache( 2 )
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.get(3);       // returns 3.
 * cache.put(4, 4);    // evicts key 1.
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class LFUCacheLeetCode {

    //One important point not mentioned in the question is the definition of "Use". According to the test cases, both set
    //and get (not just get) are considered use. So if a new key is added, its freq is 1, and more importantly, when a
    //key's value is updated, its frequency increases.

    //Idea is to use 3 hashmaps. The first two are obvious. The freqToKeys hashmap stores a mapping from frequencies to
    //a hashset of keys having that frequency. But its crucial that the mapping is not to a normal hashset but a
    //LinkedHashSet. A linked hashset is same as a hashset but the objects being inserted in the hashset are also connected
    //by a doubly linked list. Insert, delete, retrieve all use normal hashset functions O(1). Only iteration uses this
    //extra doubly linked list pointer connecting the hashset objects to iterate in the order they were inserted. This
    //helps us because among elements having the same frequency, we want the one that was inserted first (least recently).
    //
    public static class LFUCache {

        HashMap<Integer,Integer> keyToVal;
        HashMap<Integer,Integer> keyToFreq;
        HashMap<Integer,LinkedHashSet<Integer>> freqToKeys;//LinkedHashSet is a HashSet with a doubly linked list running
        int min, cap;                                      //through its elements in order of insertion. Its really Awesome!!!!

        public LFUCache(int capacity) {
            keyToVal=new HashMap<>();
            keyToFreq=new HashMap<>();
            freqToKeys=new HashMap<>();
            freqToKeys.put(1,new LinkedHashSet<>());
            cap=capacity;
            min=0;
        }

        public int get(int key) {
            if(!keyToVal.containsKey(key))
                return -1;
            int value=keyToVal.get(key);
            int count=keyToFreq.get(key);
            keyToFreq.put(key,count+1);
            freqToKeys.get(count).remove(key);
            if(!freqToKeys.containsKey(count+1))
                freqToKeys.put(count+1,new LinkedHashSet<>());
            freqToKeys.get(count+1).add(key);
            if(count==min && freqToKeys.get(count).isEmpty())
                min++;
            return value;
        }

        public void put(int key, int value) {
            if(cap==0) return;
            if(keyToVal.containsKey(key)){
                keyToVal.put(key,value);
                get(key);
                return;
            }
            if(keyToVal.size()>=cap){
                int evict=freqToKeys.get(min).iterator().next();
                freqToKeys.get(min).remove(evict);
                keyToVal.remove(evict);
                keyToFreq.remove(evict);
            }
            keyToVal.put(key,value);
            keyToFreq.put(key,1);
            freqToKeys.get(1).add(key);
            min=1;

        }
    }

    public static void main(String args[]){
        /**
         * Your LFUCache object will be instantiated and called as such:
         * LFUCache obj = new LFUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */

        LFUCache cache=new LFUCache(2);
        cache.put(1,1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);                        // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);                        // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
