/**
 * Created by S N Rao on 4/25/2017.
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
public class ExcelSheetColumnTitleLeetCode {

    public static String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while(n>0){
            int rem=(n-1)%26;
            n=(n-1)/26;
            sb.append((char)('A'+rem));
        }
        return sb.reverse().toString();
    }

    public static void main(String args[]){
        System.out.println(convertToTitle(152)); //EV
    }
}
