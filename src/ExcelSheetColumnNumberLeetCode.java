/**
 * Created by S N Rao on 3/22/2017.
 *
 * Related to question Excel Sheet Column Title
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 */
public class ExcelSheetColumnNumberLeetCode {

    public static int titleToNumber(String s) {
        char[] st=s.toCharArray();
        int len=st.length, result=0;
        for(int i=1;i<len;i++) result+=Math.pow(26,i);
        int exp=1;
        for(int i=len-1;i>=0;i--){
            result+=(exp*(st[i]-'A'));
            exp*=26;
        }
        result++;
        return result;
    }

    public static void main(String args[]){
        System.out.print(titleToNumber("AABB"));
    }
}
