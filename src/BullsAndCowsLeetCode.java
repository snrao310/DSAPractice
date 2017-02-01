import java.util.HashMap;

/**
 * Created by S N Rao on 1/31/2017.
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the
 * secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to
 * eventually derive the secret number.
 *
 * For example:
 *
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B
 * to indicate the cows. In the above example, your function should return "1A3B".
 *
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 *
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 *
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 */
public class BullsAndCowsLeetCode {

    public static String getHint(String secret, String guess) {
        HashMap<Character,Integer> position=new HashMap<>();
        HashMap<Character,Integer> count=new HashMap<>();
        int cows=0,bulls=0;
        for(int i=0;i<secret.length();i++) {
            char c1=secret.charAt(i);
            char c2=guess.charAt(i);
            if(c1==c2)
                bulls++;
            else
                count.put(c1,count.getOrDefault(c1,0)+1);
        }
        for(int i=0;i<secret.length();i++){
            char c1=secret.charAt(i);
            char c2=guess.charAt(i);
            if(c1!=c2) {
                if (count.containsKey(c2) && count.get(c2)>0){
                    cows++;
                    count.put(c2,count.get(c2)-1);
                }
            }
        }
        return Integer.toString(bulls)+"A"+Integer.toString(cows)+"B";
    }

    public static void main(String args[]){
        System.out.println(getHint("1807","7810"));
        System.out.println(getHint("1123","0111"));
    }
}
