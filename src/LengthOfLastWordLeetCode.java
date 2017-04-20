/**
 * Created by S N Rao on 4/20/2017.
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last
 * word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 */
public class LengthOfLastWordLeetCode {

    public static int lengthOfLastWord(String s) {
        boolean hasSpace=false, wordFound=false;
        int result=0, len=-1;

        //Trimming end spaces
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ') {
                len=i; break;
            }
        }

        //Counting last word
        for(int i=len;i>=0;i--){
            if(s.charAt(i)==' ') break;
            else result++;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(lengthOfLastWord("Hello World"));
    }

}
