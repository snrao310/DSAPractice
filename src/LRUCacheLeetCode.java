import java.util.HashMap;

/**
 * Created by S N Rao on 3/30/2017.
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - [Set] or [insert the value if the key is not already present]. When the cache reached its capacity, it
 * should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 * LRUCache cache = new LRUCache( 2 );
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // returns 1
 * cache.put(3, 3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4, 4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 *
 */
public class LRUCacheLeetCode {
    //One important point not mentioned in the question is the definition of "Use". According to the test cases, both put
    //and get (not just get) are considered use. So if a new key is added, it becomes the most recent now, and more
    //importantly, when a key's value is updated, it becomes the most recent key.
    //
    //Idea is use a doubly linked list of keys. Least recent at the back, most recent at the front of the list. Whenever
    //a node is used, bring it to the front and make it most recent. Whenever we need to evict, advance least recent by
    //one and delete the previous least recent node. Maintain a HashMap to access the nodes using their keys.
    public static class LRUCache {

        private class ListNode{
            int key;
            ListNode next,prev;
            ListNode(int x){key=x;}
        }

        HashMap<Integer,Integer> keyToVal;
        HashMap<Integer,ListNode> keyToNode;
        ListNode mostRecent,leastRecent;
        int cap,size;

        public LRUCache(int capacity) {
            keyToVal=new HashMap<>();
            keyToNode=new HashMap<>();
            mostRecent=leastRecent=null;
            cap=capacity; size=0;
        }

        public int get(int key) {
            if(!keyToVal.containsKey(key)) return -1;
            int val=keyToVal.get(key);
            ListNode node=keyToNode.get(key);
            if(node==mostRecent)
                return val;

            ListNode prev=node.prev, next=node.next;
            if(prev!=null)
                prev.next=node.next;
            if(next!=null)
                next.prev=node.prev;
            mostRecent.next=node;
            node.prev=mostRecent;
            node.next=null;
            mostRecent=node;
            if(node==leastRecent)
                leastRecent=next;
            return val;
        }

        public void put(int key, int value) {
            if(cap==0) return;
            if(!keyToVal.containsKey(key)){
                keyToVal.put(key,value);
                ListNode node=new ListNode(key);
                keyToNode.put(key,node);
                size++;
                if(mostRecent==null)
                    mostRecent=leastRecent=node;
                else{
                    mostRecent.next=node;
                    node.prev=mostRecent;
                    node.next=null;
                    mostRecent=node;
                    if(size>cap){
                        keyToVal.remove(leastRecent.key);
                        keyToNode.remove(leastRecent.key);
                        leastRecent=leastRecent.next;
                        size--;
                    }
                }
            }
            else {
                keyToVal.put(key,value);
                get(key);
            }
        }
    }

    public static void main(String args[]){
        /**
         * Your LRUCache object will be instantiated and called as such:
         * LRUCache obj = new LRUCache(capacity);
         * int param_1 = obj.get(key);
         * obj.put(key,value);
         */
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
