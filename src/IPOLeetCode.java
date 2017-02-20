import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by S N Rao on 2/20/2017.
 *
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode
 * would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can
 * only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital
 * after finishing at most k distinct projects.
 *
 * You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to
 * start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure
 * profit and the profit will be added to your total capital.
 *
 * To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output
 * your final maximized capital.
 *
 * Example 1:
 * Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 *
 * Output: 4
 *
 * Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 * After finishing it you will obtain profit 1 and your capital becomes 1.
 * With capital 1, you can either start the project indexed 1 or the project indexed 2.
 * Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 * Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 *
 * Note:
 * You may assume all numbers in the input are non-negative integers.
 * The length of Profits array and Capital array will not exceed 50,000.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 *
 */
public class IPOLeetCode {

    private static class ProfitCapitalPair{
        int profit;
        int capital;
        public ProfitCapitalPair(int p,int c){
            profit=p;
            capital=c;
        }
    }

    //Sort by capital and whenever capital increases add all the new projects you can now have capital for into the heap.
    //Select one that gives max profit i.e. increases capital most. Increase capital and repeat again till k projects selected.
    public static int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int length=Profits.length;
        if(length==0) return W;
        ProfitCapitalPair[] pcpairs=new ProfitCapitalPair[length];
        for(int i=0;i<length;i++){
            pcpairs[i]=new ProfitCapitalPair(Profits[i],Capital[i]);
        }

        Arrays.sort(pcpairs, new Comparator<ProfitCapitalPair>() {
            @Override
            public int compare(ProfitCapitalPair o1, ProfitCapitalPair o2) {
                return o1.capital-o2.capital;   //cool way instead of returning 1,-1 and 0. The sign must be right. That's all.
            }
        });

        PriorityQueue<ProfitCapitalPair> maxProfitHeap=new PriorityQueue<>(new Comparator<ProfitCapitalPair>() {
            @Override
            public int compare(ProfitCapitalPair o1, ProfitCapitalPair o2) {
                return o2.profit-o1.profit;     //reversed because we want max heap.
            }
        });

        int maxCapacity=W, pointer=0;
        for(int i=0;i<k;i++){
            while(pointer<length && pcpairs[pointer].capital <= maxCapacity){
                maxProfitHeap.offer(pcpairs[pointer++]);
            }
            if(maxProfitHeap.isEmpty()) break;
            maxCapacity+=maxProfitHeap.poll().profit;
        }

        return maxCapacity;
    }

    public static void main(String args[]){
        System.out.print(findMaximizedCapital(2,0,new int[]{1,2,3},new int[]{0,1,1}));
    }
}
