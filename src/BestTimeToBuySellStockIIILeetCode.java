/**
 * Created by S N Rao on 2/27/2017.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */
public class BestTimeToBuySellStockIIILeetCode {

    public static int maxProfit(int[] prices) {
        int len=prices.length, maxProfit;
        if(len<2) return 0;
        int[] dp=new int[len];    //dp[i]=the max profit from single buy/sell in subarry from 0 to i.

        int min=prices[0], profit=0, curProfit=0;
        for(int i=1;i<len;i++){
            min=Math.min(prices[i],min);
            profit=prices[i]-min;
            curProfit=Math.max(curProfit,profit);
            dp[i]=curProfit;
        }

        maxProfit=dp[len-1];   //one time sell/buy may be the answer.

        //coming backward finding the max profit from ith index to end of array.
        curProfit=0;
        int max=prices[len-1];
        for(int i=len-1;i>=1;i--){
            max=Math.max(prices[i],max);
            profit=max-prices[i];
            curProfit=Math.max(curProfit,profit);
            maxProfit=Math.max(dp[i-1]+curProfit,maxProfit);
        }
        return maxProfit;
    }

    public static void main(String args[]){
        System.out.print(maxProfit(new int[]{1,0,0,1,3,2,8,5,7,6}));
    }
}
