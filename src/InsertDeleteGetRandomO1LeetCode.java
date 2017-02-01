import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 * being returned.
 *
 */
public class InsertDeleteGetRandomO1LeetCode {

    public static class RandomizedSet {

        ArrayList<Integer> list;
        HashMap<Integer,Integer> locations; //this will be HashMap<Integer,Set<Integer>> if duplicates are allowed.

        /** Initialize your data structure here. */
        public RandomizedSet() {
            list=new ArrayList();
            locations=new HashMap<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(locations.containsKey(val)) return false;
            list.add(val);
            locations.put(val,list.size()-1);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(!locations.containsKey(val)) return false;
            int index=locations.get(val);
            int last=list.size()-1;
            if(last!=index) {    //replace with last element in list
                list.set(index, list.get(last));
                locations.put(list.get(last),index);
            }
            list.remove(last);
            locations.remove(val);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int index=(int) (Math.random() *(list.size()));
            return list.get(index);
        }
    }

    public static void main(String args[]){

        /**
         * Your RandomizedSet object will be instantiated and called as such:
         * RandomizedSet obj = new RandomizedSet();
         * boolean param_1 = obj.insert(val);
         * boolean param_2 = obj.remove(val);
         * int param_3 = obj.getRandom();
         */

        RandomizedSet obj=new RandomizedSet();
        System.out.println("Inserting 2: "+obj.insert(2));
        System.out.println("Inserting 4: "+obj.insert(4));
        System.out.println("Inserting 5: "+obj.insert(5));
        System.out.println("Inserting 8: "+obj.insert(8));
        System.out.println("Inserting 12: "+obj.insert(12));
        System.out.println("Inserting 5: "+obj.insert(5));
        System.out.println("Removing 5: "+obj.remove(5));
        System.out.println("Random: "+obj.getRandom());

    }
}
