import java.util.Random;

/**
 * Created by S N Rao on 4/18/2017.
 *
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 *
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 *
 * -1 : My number is lower
 * 1 : My number is higher
 * 0 : Congrats! You got it!
 *
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 *
 */
public class GuessNumberHigherOrLowerLeetCode {

    static int guessNumber=12;
    public static int guess(int g){
        if(g<guessNumber) return 1;
        if(g>guessNumber) return -1;
        return 0;

    }

    public static int guessNumber(int n) {
        Random rand=new Random();
        int g=rand.nextInt(n)+1;
        int min=1, max=n, res=guess(g);
        while(res!=0){
            if(res==-1) max=g-1;
            if(res==1) min=g+1;
            g=rand.nextInt((max-min)+1)+min;
            res=guess(g);
        }
        return g;
    }

    public static void main(String args[]){
        System.out.print(guessNumber(18));
    }
}
