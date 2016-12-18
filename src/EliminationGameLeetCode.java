/**
 * Created by snrao on 12/17/16.
 *
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 *
 */

public class EliminationGameLeetCode {

    public static int lastRemaining(int n) {
        int result=0;
        return 1+lastRemainRecursive(n,true);
    }

    //recursive right to left and then left to right. The challenge is conquer step where you
    //need to decide how to change the index in new array.
    public static int lastRemainRecursive(int n,boolean leftToRight){
        if(n==1)
            return 0;
        if(n==2){
            if(leftToRight)
                return 1;
            else
                return 0;
        }

        int num=lastRemainRecursive(n/2,!leftToRight);
        if(leftToRight)
            return num*2 +1 ;
        else{
            if((n &1)!=1)
                return num*2;
            else
                return num*2+1;

        }
    }

    public static void main(String args[]){
        System.out.print(lastRemaining(5));
    }
}
