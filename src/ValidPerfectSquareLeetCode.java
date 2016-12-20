/**
 * Created by snrao on 12/19/16.
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 */
public class ValidPerfectSquareLeetCode {

    //Standard binary search algorithm searching for square root.
    public static boolean isPerfectSquare(int num) {
        if(num==1) return true;
        if(num==4) return true;

        long low=0,high=num/2;
        while(low<=high){
            long mid=(low+high)/2;
            long square=mid*mid;
            if(square==num)
                return true;
            else if(square>num)
                high=mid-1;
            else //square<num
                low=mid+1;
        }
        return false;
    }

    public static void main(String args[]){
        System.out.print(isPerfectSquare(2401));
    }
}
