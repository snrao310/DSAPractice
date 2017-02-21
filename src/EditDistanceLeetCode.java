/**
 * Created by S N Rao on 2/21/2017.
 *
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation
 * is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *
 */
public class EditDistanceLeetCode {

    public static int minDistance(String word1, String word2) {
        int m=word1.length(),n=word2.length();
        if(m==0) return n;
        if(n==0) return m;
        int[][] dp=new int[++m][++n];
        char[] w1=word1.toCharArray();
        char[] w2=word2.toCharArray();

        //first column is w1 to null string. first row is null string to w2.
        for(int i=1;i<m;i++)
            dp[i][0]=1+dp[i-1][0];
        for(int i=1;i<n;i++)
            dp[0][i]=1+dp[0][i-1];

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(w1[i-1]==w2[j-1])
                    dp[i][j]=dp[i-1][j-1];
                else
                    dp[i][j]=1+Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1]));
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String args[]){
        System.out.print(minDistance("alphabet","wolfphabemma")); //6
    }
}
