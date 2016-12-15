/**
 * Created by S N Rao on 10/4/2016.
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 */
public class BestTimeToBuySellStockIILeetCode {

    public static int maxProfit(int[] prices) { //Can buy multiple times and sell multiple times.
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }

    public static void main(String args[]){
        int prices[]={2,3,1,5,7,2,5};
        maxProfit(prices);                  //Can buy multiple times and sell multiple times.
    }
}
