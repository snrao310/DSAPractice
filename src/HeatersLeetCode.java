import java.util.Arrays;

/**
 * Created by S N Rao on 4/21/2017.
 *
 * Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all
 * the houses.
 *
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that
 * all houses could be covered by those heaters.
 *
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum
 * radius standard of heaters.
 *
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 *
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses
 * can be warmed.
 *
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses
 * can be warmed.
 *
 */
public class HeatersLeetCode {

    //The idea is to leverage decent Arrays.binarySearch() function provided by Java.
    //1. For each house, find its position between those heaters (thus we need the heaters array to be sorted).
    //2. Calculate the distances between this house and left heater and right heater, get a MIN value of those two values.
    //   Corner cases are there is no left or right heater.
    //3. Get MAX value among distances in step 2. It's the answer.
    // Time complexity: max(O(nlogn), O(mlogn)) - m is the length of houses, n is the length of heaters.
    //
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int result=Integer.MIN_VALUE;
        for(int i:houses){
            int index=Arrays.binarySearch(heaters, i);
            if(index<0)
                index=-(index+1);

            int dist1=(index!=heaters.length)?heaters[index]-i:Integer.MAX_VALUE;
            int dist2=(index!=0)?i-heaters[index-1]:Integer.MAX_VALUE;

            result=Math.max(result,Math.min(dist1,dist2));
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(findRadius(new int[]{1,5},new int[]{10})); //9
    }
}
