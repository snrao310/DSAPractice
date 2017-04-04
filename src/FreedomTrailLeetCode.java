import java.util.Arrays;

/**
 * Created by S N Rao on 4/3/2017.
 *
 * In the video game Fallout 4, the quest "Road to Freedom" requires players to reach a metal dial called the "Freedom
 * Trail Ring", and use the dial to spell a specific keyword in order to open the door.
 *
 * Given a string ring, which represents the code engraved on the outer ring and another string key, which represents
 * the keyword needs to be spelled. You need to find the minimum number of steps in order to spell all the characters
 * in the keyword.
 *
 * Initially, the first character of the ring is aligned at 12:00 direction. You need to spell all the characters in
 * the string key one by one by rotating the ring clockwise or anticlockwise to make each character of the string key
 * aligned at 12:00 direction and then by pressing the center button.
 *
 * At the stage of rotating the ring to spell the key character key[i]:
 * You can rotate the ring clockwise or anticlockwise one place, which counts as 1 step. The final purpose of the
 * rotation is to align one of the string ring's characters at the 12:00 direction, where this character must equal to
 * the character key[i].
 *
 * If the character key[i] has been aligned at the 12:00 direction, you need to press the center button to spell, which
 * also counts as 1 step. After the pressing, you could begin to spell the next character in the key (next stage),
 * otherwise, you've finished all the spelling.
 *
 * Example:
 * Input: ring = "godding", key = "gd"
 * Output: 4
 * Explanation:
 * For the first key character 'g', since it is already in place, we just need 1 step to spell this character.
 * For the second key character 'd', we need to rotate the ring "godding" anticlockwise by two steps to make it become "ddinggo".
 * Also, we need 1 more step for spelling.
 * So the final output is 4.
 *
 * Note:
 * Length of both ring and key will be in range 1 to 100.
 * There are only lowercase letters in both strings and might be some duplcate characters in both strings.
 * It's guaranteed that string key could always be spelled by rotating the string ring.
 *
 */
public class FreedomTrailLeetCode {


    //DP[i]= Minimum steps to reach the ith index of the ring where the ith index of the ring has current key character.
    //Its infinite if the character at ith index does not match current key character.
    //Updated at every iteration (index of key)
    //Can also use a 2D array with one index for index of key. But this is more efficient.
    public static int findRotateSteps(String ring, String key) {
        int m=ring.length(), n=key.length();
        int[] DP=new int[m];
        Arrays.fill(DP,Integer.MAX_VALUE);
        DP[0]=0;

        for(int i=0;i<n;i++){               //i iterates through key indices
            char c=key.charAt(i);
            int[] nextDP=new int[m];                //New DP. The actual DP will be set to this array after this iteration.
            Arrays.fill(nextDP,Integer.MAX_VALUE);

            for(int j=0;j<m;j++){           //j iterates through ring and check if anything matches current key index
                if(key.charAt(i)==ring.charAt(j)){

                    for(int k=0;k<m;k++){                   //Iterate through DP (which has previous mins) and for all the indices with non-infinite
                        if(DP[k]!=Integer.MAX_VALUE) {      //values (ring indices that matched previous key character), find minimum steps to move from here to j.
                            int minSteps=Math.min(Math.abs(j-k), m - Math.abs(j-k));
                            nextDP[j] = Math.min(nextDP[j], DP[k] + minSteps);
                        }
                    }
                }
            }
            DP=nextDP;  //Update DP array
        }
        int min=Integer.MAX_VALUE;
        for(int i:DP) min=Math.min(min,i);      //Find min dp value among all the indices that match last key index (rest will be infinite)
        return min+n;    //adding n for button presses
    }

    public static void main(String args[]){
        System.out.println(findRotateSteps("godding","gd"));
        System.out.println(findRotateSteps("godding","godding"));
    }
}
