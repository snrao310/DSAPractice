import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 3/2/2017.
 *
 * Implement a data structure supporting the following operations:
 *
 * 1. Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty
 * string.
 * 2. Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the
 * key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * 3. GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * 4. GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 *
 * Challenge: Perform all these in O(1) time complexity.
 */
public class AllOOneDataStructureLeetCode {

    public static class AllOne {

        //Doubly linked list
        private class ListNode {
            HashSet<String> set;
            int val = 0;
            ListNode next;
            ListNode prev;
            ListNode(int v, HashSet<String> s) {val = v; set = s;}
        }

        ListNode max;
        ListNode min;
        ListNode zero;
        HashMap<String, ListNode> counts;


        private void addNext(ListNode count){
            ListNode temp = count.next;
            ListNode newNode = new ListNode(count.val + 1, new HashSet<>());
            count.next = newNode;
            newNode.prev = count;
            newNode.next = temp;
            if (temp != null) temp.prev = newNode;
        }

        private void addPrev(ListNode count){
            ListNode temp = count.prev;
            ListNode newNode = new ListNode(count.val - 1, new HashSet<>());
            count.prev = newNode;
            newNode.prev = temp;
            newNode.next = count;
            if (temp != null) temp.next = newNode;
        }

        private void deleteNode(ListNode count){
            if (count.prev != null) count.prev.next = count.next;
            if (count.next != null) count.next.prev = count.prev;
        }

        /**
         * Initialize your data structure here.
         */
        public AllOne() {
            counts = new HashMap<>();
            zero = new ListNode(0, new HashSet<>());
            min=zero; max=zero;
        }

        /**
         * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
         */
        public void inc(String key) {
            if (!counts.containsKey(key))
                counts.put(key, zero);
            ListNode count = counts.get(key);
            if (count.next==null || count.next.val != count.val + 1)
                addNext(count);
            count.set.remove(key);
            count.next.set.add(key);
            counts.put(key, count.next);
            if (count.set.size() == 0 && count != zero)
                deleteNode(count);
            min=(zero.next==null)?zero:zero.next;
            if (max == count) max = count.next;
        }

        /**
         * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
         */
        public void dec(String key) {
            if (!counts.containsKey(key))
                return;
            ListNode count = counts.get(key);
            if (count.prev.val != count.val - 1)
                addPrev(count);

            count.set.remove(key);
            if(count.val!=1)count.prev.set.add(key);
            if(count.val!=1)counts.put(key, count.prev);
            else counts.remove(key);

            if (count.set.size() == 0) {
                deleteNode(count);
                if (max == count) max = count.prev;
            }
            min=(zero.next==null)?zero:zero.next;
        }

        /**
         * Returns one of the keys with maximal value.
         */
        public String getMaxKey() {
            if(max==zero) return "";
            return max.set.iterator().next();
        }

        /**
         * Returns one of the keys with Minimal value.
         */
        public String getMinKey() {
            if(min==zero) return "";
            return min.set.iterator().next();
        }
    }

    public static void main(String args[]) {
        /**
         * Your AllOne object will be instantiated and called as such:
         * AllOne obj = new AllOne();
         * obj.inc(key);
         * obj.dec(key);
         * String param_3 = obj.getMaxKey();
         * String param_4 = obj.getMinKey();
         */

        AllOne ob = new AllOne();
        ob.inc("hel");
        ob.inc("hel");
        ob.inc("leet");
        System.out.print(ob.getMaxKey() + " " + ob.getMinKey());
    }
}
