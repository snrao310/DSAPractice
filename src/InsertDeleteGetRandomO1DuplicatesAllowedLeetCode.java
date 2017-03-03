import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 3/2/2017.
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * Note: Duplicate elements are allowed.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. The probability of each element being returned is
 * linearly related to the number of same value the collection contains.
 *
 */
public class InsertDeleteGetRandomO1DuplicatesAllowedLeetCode {

    public static class RandomizedCollection {

        HashMap<Integer,HashSet<Integer>> locations;
        ArrayList<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            list=new ArrayList<>();
            locations=new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean hadIt=locations.containsKey(val);
            if(!hadIt) locations.put(val,new HashSet<>());
            locations.get(val).add(list.size());
            list.add(val);
            return !hadIt;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if(!locations.containsKey(val)) return false;
            HashSet<Integer> indices=locations.get(val);
            int index=indices.iterator().next();
            indices.remove(index);
            if(indices.size()==0)
                locations.remove(val);

            int last=list.size()-1;
            if(last!=index){
                list.set(index,list.get(last));
                locations.get(list.get(last)).remove(last);
                locations.get(list.get(last)).add(index);
            }
            list.remove(last);
            return true;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int size=list.size();
            int random=(int)(size*Math.random());
            return list.get(random);
        }
    }

    public static void main(String args[]){

        /**
         * Your RandomizedCollection object will be instantiated and called as such:
         * RandomizedCollection obj = new RandomizedCollection();
         * boolean param_1 = obj.insert(val);
         * boolean param_2 = obj.remove(val);
         * int param_3 = obj.getRandom();
         */

        RandomizedCollection obj=new RandomizedCollection();
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
