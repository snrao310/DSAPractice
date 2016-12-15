/**
 * Created by S N Rao on 10/4/2016.
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
