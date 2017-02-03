import java.util.Arrays;

/**
 * Created by S N Rao on 2/2/2017.
 *
 * Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the
 * array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have been chosen. The player with the maximum
 * score wins.
 *
 * Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his
 * score.
 *
 */
public class PredictTheWinnerLeetCode {

    public static boolean PredictTheWinner(int[] nums) {
        int len=nums.length,sum=0;
        if(len==0) return false;
        int dp[][]=new int[len][len];
        for(int i=0;i<len;i++){
            Arrays.fill(dp[i],-1);
            dp[i][i]=nums[i];
            if(i<len-1)dp[i][i+1]=Math.max(nums[i],nums[i+1]);
            sum+=nums[i];
        }
        if(sum==0) return true;
        return canWin(0,len-1,0,0,dp,nums,(int)Math.ceil((double) sum/2));
    }

    //With DP.
    private static boolean canWin(int start,int end,int s1,int s2,int[][] dp, int[] nums,int halfSum){
        if(dp[start][end]!=-1){
            if(s1+dp[start][end]>=halfSum) return true;
            else return false;
        }

        boolean a=canWin(start+1,end,s2,s1+nums[start],dp,nums,halfSum);
        boolean b=canWin(start,end-1,s2,s1+nums[end],dp,nums,halfSum);
        int choice1=(start+2>end)?0:dp[start+2][end];
        int choice2=(end-2<start)?0:dp[start][end-2];
        int choice3=dp[start+1][end-1];
        int min1=nums[start] + Math.min(choice3,choice1);
        int min2=nums[end] + Math.min(choice3,choice2);
        dp[start][end]=Math.max(min1,min2);
        if(!a || !b ) return true;
        return false;
    }

    //Without DP
    private static boolean canWin(int start,int end,int s1,int s2,int[][] dp, int[] nums){
        if(start>end){
            if(s1>=s2) return true;
            else return false;
        }

        boolean a=canWin(start+1,end,s2,s1+nums[start],dp,nums);
        boolean b=canWin(start,end-1,s2,s1+nums[end],dp,nums);
        if(!a || !b) return true;
        return false;
    }

    public static void main(String args[]){
        System.out.print(PredictTheWinner(new int[]{1,1,1}));
    }
}
