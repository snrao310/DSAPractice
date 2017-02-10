import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 2/10/2017.
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongestConsecutiveSequenceLeetCode {

    public static int longestConsecutive(int[] nums) {
        if(nums.length==0 || nums.length==1) return nums.length;
        HashMap<Integer,Integer> startToEnd=new HashMap<>();
        HashMap<Integer,Integer> endToStart=new HashMap<>();
        HashSet<Integer> seen=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            int now=nums[i], start=now, end=now;
            if(seen.contains(now)) continue;
            seen.add(now);
            if(startToEnd.containsKey(now+1)){
                end=startToEnd.get(now+1);
                startToEnd.remove(now+1);
                endToStart.remove(end);
            }
            if(endToStart.containsKey(now-1)){
                start=endToStart.get(now-1);
                endToStart.remove(now-1);
                startToEnd.remove(start);
            }
            startToEnd.put(start,end);
            endToStart.put(end,start);
        }

        int max=1;
        for(int i:startToEnd.keySet()){
            max=Math.max(max, startToEnd.get(i)-i+1);
        }
        return max;
    }

    public static void  main(String args[]){
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
