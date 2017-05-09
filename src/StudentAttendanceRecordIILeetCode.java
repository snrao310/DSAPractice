/**
 * Created by S N Rao on 5/6/2017.
 *
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be
 * regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L'
 * (late).
 *
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 *
 * Note: The value of n won't exceed 100,000.
 *
 */
public class StudentAttendanceRecordIILeetCode {

    //dp[i][j][k] = possible rewardable arrangements of length i, with j A's (0 or 1), with k trailing L's (0 or 1 or 2).
    //Solution is O(n).
    public static int checkRecord(int n) {
        int m=1000000007;
        int dp[][][]=new int[n][2][3];
        dp[0][0][0]=1; dp[0][0][1]=1; dp[0][1][0]=1;

        for(int i=1;i<n;i++){
            dp[i][0][0]=((dp[i-1][0][0]+dp[i-1][0][1])%m+dp[i-1][0][2])%m;
            dp[i][0][1]=(dp[i-1][0][0])%m;
            dp[i][0][2]=(dp[i-1][0][1])%m;
            dp[i][1][0]=(((((dp[i-1][0][0] + dp[i-1][1][0])%m + dp[i-1][0][1])%m + dp[i-1][1][1])%m + dp[i-1][0][2])%m + dp[i-1][1][2])%m;
            dp[i][1][1]=(dp[i-1][1][0])%m;
            dp[i][1][2]=(dp[i-1][1][1])%m;
        }
        int res=0;
        for(int i=0;i<3;i++)
            res=(res+(dp[n-1][0][i]+dp[n-1][1][i])%m)%m;
        return res;
    }

    public static void main(String args[]){
        System.out.print(checkRecord(36));
    }
}
