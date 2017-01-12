/**
 * Created by S N Rao on 1/12/2017.
 *
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent
 * number in the sequence must be the sum of the preceding two.
 *
 *
 */
public class AdditiveNumberLeetCode {

    public static boolean isAdditiveNumber(String num) {
        int n=num.length();
        if(n<3) return false;
        for(int i=0;i<=(n-1)/2;i++){
            if(num.charAt(0)=='0' && i!=0) continue;
            for(int j=i+1;(i+1<=n-j) && (i-j<=n-j);j++){
                if(num.charAt(i+1)=='0' && j-i>1) continue;
                if(recursiveFunction(Long.parseLong(num.substring(0,i+1)),Long.parseLong(num.substring(i+1,j+1)),num.substring(j+1)))
                    return true;
            }
        }
        return false;
    }

    private static boolean recursiveFunction(long fnumber, long snumber, String num){
        String sum=Long.toString(fnumber+snumber);
        if(num.indexOf(sum)!=0) return false;

        int start=sum.length(), n=num.length();
        if(sum.length()==num.length()) return true;

        if(recursiveFunction(snumber,fnumber+snumber,num.substring(start)))
            return true;

        return false;
    }

    public static void main(String args[]){
        System.out.println(isAdditiveNumber("0213"));
        System.out.println(isAdditiveNumber("199100199"));
    }
}
