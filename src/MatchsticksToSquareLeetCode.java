import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by snrao on 12/29/16.
 *
 * Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl
 * has, please find out a way you can make one square by using up all those matchsticks. You should not break
 * any stick, but you can link them up, and each matchstick must be used exactly one time.
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will
 * either be true or false, to represent whether you could make one square using all the matchsticks the little
 * match girl has.
 *
 */
public class MatchsticksToSquareLeetCode {

    public static boolean makesquare(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            sum+=i;
        }

        if(sum%4!=0) return false;
        sum=sum/4;

        if(!backTrackFunction(map,new ArrayList<>(),nums,nums.length-1,sum)) return false;
        if(!backTrackFunction(map,new ArrayList<>(),nums,nums.length-1,sum)) return false;
        if(!backTrackFunction(map,new ArrayList<>(),nums,nums.length-1,sum)) return false;
        if(!backTrackFunction(map,new ArrayList<>(),nums,nums.length-1,sum)) return false;
        return true;
    }

    public static boolean backTrackFunction(HashMap<Integer,Integer> map, List<Integer> tempList,
                                            int[] nums, int start, int sum){
        if(start==-1) return false;

        for (int i=start;i>=0;i--){
            if(map.get(nums[i])==0) continue;
            if(nums[i]>sum) continue;
            tempList.add(nums[i]);
            map.put(nums[i],map.get(nums[i])-1);
            if(sum==nums[i])
                return true;
            if(backTrackFunction(map,tempList,nums,i-1,sum-nums[i]))
                return true;
            else {
                int put=tempList.get(tempList.size()-1);
                map.put(put,map.get(put)+1);
                tempList.remove(tempList.size() - 1);
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(makesquare(new int[]{4,1,1,1,3,3,3,4}));
    }
}
