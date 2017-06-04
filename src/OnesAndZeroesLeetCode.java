
/**
 * Created by snrao on 12/23/16.
 *
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want
 * to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array
 * with strings consisting of only 0s and 1s.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0
 * and 1 can be used at most once.
 */
public class OnesAndZeroesLeetCode {

    /*
    Dynamic Programming filling is O(mn*Number of strings), space O(mn).
    If this string has one 0 and one 1, it will be T in the matrix below.
    Update all X then.
    AAAA
    ATXX
    AXXX
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int dp[][]=new int[m+1][n+1];
        for(String s:strs){
            int zeroes=s.length()-s.replace("0","").length();
            int ones=s.length()-zeroes;
            for(int i=m;i>=zeroes;i--){
                for(int j=n;j>=ones;j--){
                    dp[i][j]=Math.max(dp[i][j],1+dp[i-zeroes][j-ones]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String args[]){
        String strs[]={"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
