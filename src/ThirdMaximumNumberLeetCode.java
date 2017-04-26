/**
 * Created by S N Rao on 4/25/2017.
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the
 * maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */
public class ThirdMaximumNumberLeetCode {

    public static int thirdMax(int[] nums) {
        Integer max1=null, max2=null, max3=null;
        for(int i=0;i<nums.length;i++){
            if(max1==null || nums[i]>max1){
                if(max1!=null){
                    if(max2!=null) max3=max2;
                    max2=max1;
                }
                max1=nums[i];
            }
            else if(nums[i]!=max1 && (max2==null || nums[i]>max2)){
                if(max2!=null) max3=max2;
                max2=nums[i];
            }
            else if(nums[i]!=max1 && nums[i]!=max2 && (max3==null || nums[i]>max3))
                max3=nums[i];
        }
        if(max3!=null) return max3;
        else return max1;
    }

    public static void main(String args[]){
        System.out.println(thirdMax(new int[]{1,4,2,3,6,2,5})); //4
    }
}
