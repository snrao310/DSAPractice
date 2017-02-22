/**
 * Created by S N Rao on 2/22/2017.
 *
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 *
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of
 * the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of
 * "ABCDE" while "AEC" is not).
 *
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 *
 * Return 3.
 *
 */
public class DistinctSubsequencesLeetCode {

    public static int numDistinct(String s, String t) {
        int m=s.length()+1, n=t.length()+1;
        if(m==1) return 0;
        int[][] dp=new int[m][n];   //number of ways of forming substring of t (0 to n) from substring of s (0 to m)
        for(int i=0;i<n;i++) dp[0][i]=0;
        for(int i=0;i<m;i++) dp[i][0]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + ((s.charAt(i-1)==t.charAt(j-1))?dp[i-1][j-1]:0);
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.print(numDistinct("orabbbit","rabbit"));
    }
}
