/**
 * Created by S N Rao on 3/2/2017.
 *
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 */
public class NumberOfDigitOneLeetCode {

    public static int countDigitOne(int n) {
        int num=n, exp=0, res=0, prevPower=0, nextPart=0;
        while(num>0){
            int cnum=num%10;
            int power=(prevPower==0)?1:prevPower*10;
            if(cnum==1)
                res+=(exp*prevPower+ 1+nextPart);
            else if(cnum!=0)
                res+=(cnum*exp*prevPower + power);
            exp++;
            prevPower=power;
            num/=10;
            nextPart=cnum*prevPower+nextPart;
        }
        return res;
    }

    public static void main(String args[]){
        System.out.print(countDigitOne(3217));
    }
}
