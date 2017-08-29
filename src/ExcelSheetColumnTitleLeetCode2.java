/**
 * Created by S N Rao on 8/29/2017.
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 */
public class ExcelSheetColumnTitleLeetCode2 {

    public static String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>=26){
            int r=n%26;
            n/=26;
            if(r==0){
                n--;
                sb.append('Z');
            }
            else
                sb.append((char)('A'+r-1));
        }
        if(n!=0)
            sb.append((char)('A'+n-1));
        return sb.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(convertToTitle(152)); //EV
    }
}
