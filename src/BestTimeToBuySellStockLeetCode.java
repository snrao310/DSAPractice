/**
 * Created by S N Rao on 12/14/2016.
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 */
public class BestTimeToBuySellStockLeetCode {

    public static int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;

        int result=0;
        int curmin=prices[0]+1,curmax=0,min=0,max=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<curmin) {
                curmin = prices[i];
                curmax = prices[i];
            }
            else if(prices[i] > curmax)
                curmax=prices[i];
            if(curmax-curmin > max-min){
                max=curmax;
                min=curmin;
            }
        }
        result=max-min;
        return result;
    }

    public static void main(String args[]){
        int prices[]={2,3,1,5,7,2,5};
        System.out.print(maxProfit(prices));
    }
}
