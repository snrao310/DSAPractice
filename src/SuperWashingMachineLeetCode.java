/**
 * Created by S N Rao on 2/23/2017.
 *
 * You have n super washing machines on a line. Initially, each washing machine has some dresses or is empty.
 *
 * For each move, you could choose any m (1 ≤ m ≤ n) washing machines, and pass one dress of each washing machine to one
 * of its adjacent washing machines at the same time .
 *
 * Given an integer array representing the number of dresses in each washing machine from left to right on the line, you
 * should find the minimum number of moves to make all the washing machines have the same number of dresses. If it is not
 * possible to do it, return -1.
 *
 * Example1
 * Input: [1,0,5]
 * Output: 3
 * Explanation:
 * 1st move:    1     0 <-- 5    =>    1     1     4
 * 2nd move:    1 <-- 1 <-- 4    =>    2     1     3
 * 3rd move:    2     1 <-- 3    =>    2     2     2
 *
 * Example2
 * Input: [0,3,0]
 * Output: 2
 * Explanation:
 * 1st move:    0 <-- 3     0    =>    1     2     0
 * 2nd move:    1     2 --> 0    =>    1     1     1
 *
 * Example3
 * Input: [0,2,0]
 * Output: -1
 * Explanation:
 * It's impossible to make all the three washing machines have the same number of dresses.
 *
 * Note:
 * The range of n is [1, 10000].
 * The range of dresses number in a super washing machine is [0, 1e5].
 *
 */
public class SuperWashingMachineLeetCode {

    public static int findMinMoves(int[] machines) {
        int sum=0,max=Integer.MIN_VALUE, n=machines.length;
        for(int i=0;i<machines.length;i++)
            sum+=machines[i];
        if(sum%n!=0) return -1;
        int avg=sum/n;

        //Max of what each machine needs to give away. Can only give to one adjacent machine at a time.
        for(int i=0;i<machines.length;i++){
            machines[i]=machines[i]-avg;
            max=Math.max(max,machines[i]);
        }

        //Cumulative sending and receiving. While traversing from right to left, if there is no machine to recieve load
        //in the way, then the load of all machines to transfer to right keeps increasing. This will add more steps since
        //only one dress can be transferred at a time. Still very unclear but it works. Probably, a mathematical proof is
        //the only way to understand this, not logical intuition.
        for(int i=0;i<machines.length;i++){
            if(i!=machines.length-1)machines[i+1]+=machines[i];
            max=Math.max(max,Math.abs(machines[i]));
            machines[i]=0;
        }

        return max;
    }

    public static void main(String args[]){
        System.out.print(findMinMoves(new int[]{9,9,0}));
    }
}
