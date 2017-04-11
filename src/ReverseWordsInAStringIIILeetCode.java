/**
 * Created by S N Rao on 4/10/2017.
 *
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving
 * whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 *
 */
public class ReverseWordsInAStringIIILeetCode {

    public static String reverseWords(String s) {
        String[] parts=s.split(" ");
        for(int i=0;i<parts.length;i++)
            parts[i]=new StringBuilder(parts[i]).reverse().toString();
        StringBuilder sb=new StringBuilder();
        sb.append(parts[0]);
        for(int i=1;i<parts.length;i++)
            sb.append(" "+parts[i]);
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.print(reverseWords("Let's take LeetCode contest"));
    }
}
