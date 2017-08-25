/**
 * Created by S N Rao on 8/23/2017.
 *
 * Implement atoi to convert a string to an integer.
 *
 */
public class StringToIntegerAtoiLeetCode2 {

    public static int myAtoi(String str) {
        int i=0, sign=1,len=str.length();
        if(len==0) return 0;
        while(i<len && str.charAt(i)==' ') i++;
        if(str.charAt(i)=='-') {sign=-1;i++;}
        else if(str.charAt(i)=='+') {i++;}
        while(i<len && str.charAt(i)=='0') i++;
        if(i==len) return 0;
        int j=i;
        while(i<len && Character.isDigit(str.charAt(i))) i++;
        String s=str.substring(j,i);

        long number=0;
        for(i=0;i<s.length();i++){
            char c=s.charAt(i);
            int n=Character.getNumericValue(c);
            number*=10;
            number+=n;
            if(number>Integer.MAX_VALUE)
                break;
        }

        number*=sign;
        if(number>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(number<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int) number;
    }

    public static void main(String args[]){
        System.out.print(myAtoi("     010 1"));
    }
}
