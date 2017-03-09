/**
 * Created by S N Rao on 3/9/2017.
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 *
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 *
 */
public class InterleavingStringLeetCode {

    //DP[i][j] represents if s3 is interleaving at (i+j)th position when s1 is at ith position, and s2 is at jth position.
    // 0th position means empty string.
    //
    // So if both s1 and s2 is currently empty, s3 is empty too, and it is considered interleaving. If only s1 is empty,
    // then if previous s2 position is interleaving and current s2 position char is equal to s3 current position char,
    // it is considered interleaving. similar idea applies to when s2 is empty. when both s1 and s2 is not empty, then
    // if we arrive i, j from i-1, j, then if i-1,j is already interleaving and i and current s3 position equal, it s
    // interleaving. If we arrive i,j from i, j-1, then if i, j-1 is already interleaving and j and current s3 position
    // equal. it is interleaving.
    //
    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean[][] dp=new boolean[s1.length()+1][s2.length()+1];
        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0 && j==0) dp[i][j]=true;
                else if(i==0) dp[i][j]=(dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1)));
                else if(j==0) dp[i][j]=(dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1)));
                else dp[i][j]=(dp[i][j-1] && (s2.charAt(j-1)==s3.charAt(i+j-1)) || (dp[i-1][j] && (s1.charAt(i-1)==s3.charAt(i+j-1))));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String args[]){
        System.out.println(isInterleave("aabcc","dbbca","aadbbcbcac"));
        System.out.println(isInterleave("aabcc","dbbca","aadbbbaccc"));
    }
}
