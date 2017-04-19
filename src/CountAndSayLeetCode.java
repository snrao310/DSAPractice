/**
 * Created by S N Rao on 4/18/2017.
 *
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 */
public class CountAndSayLeetCode {

    //n starts with 1, not 0.
    public static String countAndSay(int n) {
        String s="1";
        for(int i=1;i<n;i++){
            s=countDigits(s);
        }
        return s;
    }

    private static String countDigits(String s){
        StringBuilder sb=new StringBuilder();
        int count=0; char cur='#';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==cur) count++;
            else{
                if(count!=0)    //count=0 only when i=0
                    sb.append(count+""+cur);
                count=1; cur=s.charAt(i);
            }
        }
        sb.append(count+""+cur);
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.print(countAndSay(2));
    }
}
