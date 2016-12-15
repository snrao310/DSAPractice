/**
 * Created by snrao on 11/5/16.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 */
public class MissingNumberLeetCode {

    //computes missing number between 0 to n.
    public static int missingNumber(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int missing= ((n)*(n+1)/2) - sum;
        return missing;
    }

    public static void main(String[] args){
        int k[]={0,1,2,4,5};
        System.out.print(missingNumber(k));
    }
}
