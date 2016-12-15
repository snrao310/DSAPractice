import java.util.Random;

/**
 * Created by S N Rao on 12/15/2016.
 * Given an array of integers with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 */
public class RandomPickIndexLeetCode {

    private static int[] nums;

    public static int pick(int target) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                count++;
        }

        Random rand=new Random();
        int n=rand.nextInt(count)+1;
        count=0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                count++;
                if(count==n)
                    return i;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        nums=new int[]{1,2,3,3,3}; //initialising after declaring. This is how its done.
        System.out.print(pick(3));
    }
}
