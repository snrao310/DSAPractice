/**
 * Created by S N Rao on 4/17/2017.
 *
 * Given a list of positive integers, the adjacent integers will perform the float division. For example,
 * [2,3,4] -> 2 / 3 / 4.
 *
 * However, you can add any number of parenthesis at any position to change the priority of operations. You should find
 * out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your
 * expression should NOT contain redundant parenthesis.
 *
 * Example:
 * Input: [1000,100,10,2]
 * Output: "1000/(100/10/2)"
 * Explanation:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 * since they don't influence the operation priority. So you should return "1000/(100/10/2)".
 *
 * Other cases:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 *
 * Note:
 * The length of the input array is [1, 10].
 * Elements in the given array will be in range [2, 1000].
 * There is only one optimal division for each test case.
 *
 */
public class OptimalDivisionLeetCode {

    //Regardless of parentheses, every element is either in the numerator or denominator of the final fraction. The idea
    // is to bring as many numbers as possible to the denominator. Its impossible to bring A[1] to denominator. The
    //expression A[0] / ( A[1] / A[2] / ... / A[N-1] ) has every element in the numerator except A[1], and it is
    //impossible for A[1] to be in the numerator, so it is the largest.
    public static String optimalDivision(int[] nums) {
        if(nums.length==1) return nums[0]+"";
        if(nums.length==2) return nums[0]+"/"+nums[1];
        StringBuilder res=new StringBuilder();
        res.append(nums[0]); res.append("/("); res.append(nums[1]);
        for(int i=2;i<nums.length;i++){
            res.append("/"+nums[i]);
        }
        res.append(")");
        return res.toString();
    }

    public static void main(String args[]){
        System.out.print(optimalDivision(new int[]{1000,100,10,2}));
    }
}
