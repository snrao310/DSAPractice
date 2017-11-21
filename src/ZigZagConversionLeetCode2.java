/**
 * Created by S N Rao on 11/14/2017.
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * Example for convert("PAYPALISHIRING", 4) shows zigzag pattern better
 *  P     I     N
 *  A   L S   I G
 *  Y A   H R
 *  P     I
 *  read as "PINALSIGYAHRPI"
 *
 */
public class ZigZagConversionLeetCode2 {

    public static String convert(String str, int numRows) {
        if(numRows==1) return str;
        char[] res=new char[str.length()];
        int len=str.length(),j=0;
        for(int i=0;i<numRows;i++){
            int k=i;
            while(k<len){
                res[j++]=str.charAt(k);
                if(i!=0 && i!=numRows-1){
                    int r=(numRows-i-1);
                    if(k+2*r < len)
                        res[j++]=str.charAt(k+2*r);
                }
                k+= ((numRows-1)*2);
            }
        }
        return new String(res);
    }

    public static void main(String args[]){
        System.out.println(convert("A",1));
    }
}
