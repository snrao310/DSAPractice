import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by S N Rao on 1/20/2017.
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first
 * causes the running total to reach or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until
 * they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force
 * a win, assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than
 * 300.
 *
 */
public class CanIWinLeetCode {

    //DP solution. O(2^n)
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((maxChoosableInteger*(maxChoosableInteger+1)/2)<desiredTotal) return false;
        if(desiredTotal<=0) return true;
        int[] available=new int[maxChoosableInteger+1];
        Arrays.fill(available,1);
        HashMap<String,Boolean> map=new HashMap<>();
        return canIWin(available,map,desiredTotal);
    }

    private static boolean canIWin(int[] available, HashMap<String,Boolean> map, int sum){
        if(sum<=0) return false;
        String key= Arrays.toString(available);
        if(map.containsKey(key))
            return map.get(key);
        for(int i=1;i<available.length;i++){
            if(available[i]==1){
                available[i]=0;
                if(!canIWin(available,map,sum-i)){
                    map.put(key,true);
                    available[i]=1;
                    return true;
                }
                available[i]=1;
            }
        }
        map.put(key,false);
        return false;
    }

    public static void main(String args[]){
        System.out.println(canIWin(10,40));
    }
}
