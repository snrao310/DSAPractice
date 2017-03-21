/**
 * Created by S N Rao on 3/20/2017.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuySellStockIVLeetCode {

    //dp[i, j] represents the max profit up until prices[j] using at most i transactions.
    //dp[i, j] = max(dp[i, j-1], prices[j] - prices[l] + dp[i-1, l-1]) { l in range of [0, j-1] }
    //          = max(dp[i, j-1], prices[j] + max(dp[i-1, l-1] - prices[l]))
    // dp[0, j] = 0; 0 transactions makes 0 profit
    // dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
    public static int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<2) return 0;

        //Can buy sell every stock, then the problem is same as BestTimeToBuySellStockIIILeetCode, where we just have to
        //add up all profits possible. If this condition is not checked, LeetCode gives memory limit exceeded.
        if(k>=n/2){
            int profit=0;
            for(int i=1;i<n;i++){
                if(prices[i]-prices[i-1]>0)
                    profit+=prices[i]-prices[i-1];
            }
            return profit;
        }

        int[][] dp=new int[k+1][n];
        for(int i=0;i<n;i++)
            dp[0][i]=0;
        for(int i=0;i<k+1;i++)
            dp[i][0]=0;

        for(int i=1;i<k+1;i++){
            int localMax=-prices[0];    //max(dp[i-1, l-1] - prices[l]) part can be computed in the j loop itself.
            for(int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i][j-1],prices[j]+localMax);
                localMax=Math.max(localMax, dp[i-1][j]-prices[j]);
            }
        }
        return dp[k][n-1];
    }

    public static void main(String args[]){
        System.out.println(maxProfit(3,new int[]{1,3,2,7,6,3,1,4}));
    }
}
