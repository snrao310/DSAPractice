/**
 * Created by S N Rao on 1/26/2017.
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
public class ZigZagConversionLeetCode {

    public static String convert(String str, int numRows) {
        if(numRows==1) return str;
        int r=numRows,n=str.length();
        char[] s=str.toCharArray();
        char[] st=new char[n];
        int k=0;
        for(int i=0;i<r;i++){
            int j=i;
            while(j<n){
                st[k++]=s[j];
                int newj=j+(2*r-2);
                if(i!=0 && i!=r-1){
                    if(newj-2*i<n)
                        st[k++]=s[newj-2*i];
                }
                j=newj;
            }
        }
        return new String(st);
    }

    public static void main(String args[]){
        System.out.println(convert("PAYPALISHIRING",4));
    }
}
