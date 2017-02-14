/**
 * Created by S N Rao on 2/14/2017.
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input:
 * "bbbab"
 *
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 *
 */
public class LongestPalindromicSequenceLeetCode {

    public static int longestPalindromeSubseq(String s) {
        int n=s.length();
        int[][] dp=new int[n][n]; //DP[i][j] will have the longenst palindromic subsequence length from i to j
        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(i==j) dp[i][j]=1;
                else if(i==j-1)
                    dp[i][j]=(s.charAt(i)==s.charAt(j))?2:1;
                else{
                    int max=Math.max(dp[i+1][j], dp[i][j-1]);
                    if(s.charAt(i)==s.charAt(j))
                        max=Math.max(max, dp[i+1][j-1]+2);
                    dp[i][j]=max;
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
