import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by S N Rao on 1/16/2017.
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the
 * fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any
 * combination of the coins, return -1.
 *
 *
 */
public class CoinChangeLeetCode {

    //DP. Top-down is better because amount may be big and filling all values before it may not be the best idea.
    // But still implementing bottom-up coz of ease.
    public static int coinChange(int[] coins, int amount) {
        int dp[]=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i<coins[j]) continue;
                dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
            }
        }
        return (dp[amount]>amount)? -1 : dp[amount];
    }

    public static void main(String args[]){
        System.out.println(coinChange(new int[]{25,7,10},109));
    }

}
