/**
 * Created by snrao on 12/10/16.
 *
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every
 * second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off
 * if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last
 * bulb. Find how many bulbs are on after n rounds.
 *
 */
public class BulbSwitcherLeetCode {
    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);

        /* Logic: kth bulb is on if the number of factors of k is odd. Factors always occur in pairs
        except when one of the factors is square root. So the number of bulbs among the n bulbs which
        are on is equal to the number of perfect squares till n. This is exactly equal to sqrt(n).
         */
    }

    public static void main(String args[]){
        System.out.print(bulbSwitch(6));
    }
}
