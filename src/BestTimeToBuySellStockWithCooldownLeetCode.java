/**
 * Created by S N Rao on 12/14/2016.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */
public class BestTimeToBuySellStockWithCooldownLeetCode {

    public static int maxProfit(int[] prices) {
        int result=0;
        if(prices.length<2)
            return 0;

        //Dynamic Programming bottom up.
        //buy[i] means before day i what is the maxProfit for any sequence end with buy.
        //sell[i] means before day i what is the maxProfit for any sequence end with sell.
        int[] buy=new int[prices.length];
        int[] sell=new int[prices.length];

        buy[0]=-prices[0];buy[1]=Math.max(buy[0],-prices[1]);
        sell[0]=0;sell[1]=Math.max(buy[0]+prices[1],sell[0]);
        for(int i=2;i<prices.length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(buy[i-1]+prices[i],sell[i-1]);
        }

        return sell[prices.length-1];
    }

    public static void main(String arg[]){
        int[] prices={2,1,4};
        System.out.println(maxProfit(prices));
    }
}
