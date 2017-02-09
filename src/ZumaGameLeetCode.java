import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by S N Rao on 2/9/2017.
 *
 * Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and
 * white(W). You also have several balls in your hand.
 *
 * Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and
 * rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls.
 * Keep doing this until no more balls can be removed.
 *
 * Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls,
 * output -1.
 *
 * Examples:
 *
 * Input: "WRRBBW", "RB"
 * Output: -1
 * Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
 *
 * Input: "WWRRBBWW", "WRBRW"
 * Output: 2
 * Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty
 *
 * Input:"G", "GGGGG"
 * Output: 2
 * Explanation: G -> G[G] -> GG[G] -> empty
 *
 * Input: "RBYYBBRRB", "YRBGB"
 * Output: 3
 * Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty
 *
 * Note:
 * You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
 * The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
 * The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
 * Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.
 *
 */
public class ZumaGameLeetCode {

    //Brute force. Actually checking all possiblities. Can use dp to make it faster but this itself was hard enough to
    //exhaust me.
    public static int findMinStep(String board, String hand) {
        int min=Integer.MAX_VALUE;
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<hand.length();i++){
            char ch=hand.charAt(i);
            if(set.contains(ch)) continue;
            set.add(ch);
            for(int j=0;j<board.length();j++){
                if(ch!=board.charAt(j)) continue;
                StringBuilder sboard=new StringBuilder(board);
                sboard.insert(j,ch);
                StringBuilder shand=new StringBuilder(hand);
                shand.deleteCharAt(i);
                reduce(sboard);
                if(sboard.length()==0) return 1;
                int cnt=findMinStep(sboard.toString(),shand.toString());
                if(cnt==-1) continue;
                min=Math.min(min,cnt+1);
            }
        }
        return (min==Integer.MAX_VALUE)?-1:min;
    }

    private static void reduce(StringBuilder str){
        for(int i=0;i<=str.length()-3;i++){
            char c=str.charAt(i);
            if(str.charAt(i+1)==c && str.charAt(i+2)==c){
                while(i<str.length() && str.charAt(i)==c){
                    str.deleteCharAt(i);
                }
                reduce(str);
            }
        }
    }

    public static void main(String args[]){
        System.out.print(findMinStep("WWRRBBWW","WRBRW"));
    }
}
