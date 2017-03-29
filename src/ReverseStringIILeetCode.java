/**
 * Created by S N Rao on 3/29/2017.
 *
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
 * start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but
 * greater than or equal to k characters, then reverse the first k characters and leave the others as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 *
 */
public class ReverseStringIILeetCode {

    public static String reverseStr(String s, int k) {
        char[] sArr=s.toCharArray();
        for(int i=0,j=0;i<sArr.length;i+=k,j++){
            if(j%2==1) continue;
            if(i+k<=sArr.length)
                reverse(sArr,i,i+k-1);
            else
                reverse(sArr,i,sArr.length-1);
        }
        return new String(sArr);
    }

    private static void reverse(char[] s,int i,int j){
        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++; j--;
        }
    }

    public static void main(String args[]){
        System.out.print(reverseStr("abcdefghijklmn",3)); //Should return cbadefihgjklnm
    }
}
