import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 2/21/2017.
 *
 * A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone.
 * The frog can jump on a stone, but it must not jump into the water.
 *
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog is able to cross the
 * river by landing on the last stone. Initially, the frog is on the first stone and assume the first jump must be 1 unit.
 *
 * If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. Note that the frog \
 * can only jump in the forward direction.
 *
 * Note:
 *
 * The number of stones is ≥ 2 and is < 1,100.
 * Each stone's position will be a non-negative integer < 231.
 * The first stone's position is always 0.
 *
 */
public class FrogJumpLeetCode {

    //Keeping track of all k values that could have been used to get to a stone as a set. At that stone, we take each of
    //them and adding to kValue set of stoned this stone + k-1/ k/ k+1
    public static boolean canCross(int[] stones) {
        if(stones.length<2) return true;
        if(stones[0]!=0 || stones[1]!=1) return false;
        if(stones.length==2) return true;

        int len=stones.length;
        HashMap<Integer,HashSet<Integer>> kValues=new HashMap<>();
        for(int i:stones)
            kValues.put(i,new HashSet<>());
        int last=stones[len-1];
        kValues.get(1).add(1);

        for(int i=1;i<len;i++){
            int stone=stones[i];
            HashSet<Integer> set=kValues.get(stone);
            for(int j: set){
                int jumpTo=stone+j-1;
                for(int k=jumpTo;k<jumpTo+3;k++){
                    if(k==stone) continue;
                    if(k==last) return true;
                    if(kValues.containsKey(k))
                        kValues.get(k).add(k-stone);
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        System.out.println(canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(canCross(new int[]{0,1,2,3,4,8,9,11}));
        System.out.println(canCross(new int[]{0,1}));
    }
}
