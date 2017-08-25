package Done;

/**
 * Created by S N Rao on 1/26/2017.
 *
 * Implement atoi to convert a string to an integer.
 *
 */
public class StringToIntegerAtoiLeetCode {

    public static int myAtoi(String str) {
        //leading zeroes
        int sign=1,i=0,j=0;
        if(str.length()==0) return 0;
        while(i<str.length() && str.charAt(i)==' ') i++;
        if(str.charAt(i)=='+') sign=1;
        if(str.charAt(i)=='-') sign=-1;
        if(str.charAt(i)=='+' ||str.charAt(i)=='-') i++;
        while(i<str.length() && str.charAt(i)=='0') i++;
        if(i==str.length()) return 0;
        j=i;
        while(i<str.length() && str.charAt(i)!='.' && str.charAt(i)!=' ') i++;
        str=str.substring(j,i);

        long pow=0;
        for(i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!Character.isDigit(c)) break;
            int cur=Character.getNumericValue(c);
            pow=pow*10+cur;
            if(pow>Integer.MAX_VALUE) break;
        }
        pow=pow*sign;
        if(pow>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(pow<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) pow;
    }

    public static void main(String args[]){
        System.out.print(myAtoi("     010 1"));
    }
}
