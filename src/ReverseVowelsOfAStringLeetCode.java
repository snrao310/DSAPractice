import java.util.HashSet;

/**
 * Created by S N Rao on 4/11/2017.
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 *
 */
public class ReverseVowelsOfAStringLeetCode {

    public static String reverseVowels(String s) {
        char[] string=s.toCharArray();
        HashSet<Character> vowels=new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
        StringBuilder sb=new StringBuilder();
        for(char c: string){
            if(vowels.contains(c))
                sb.append(c);
        }
        char[] vowelString=sb.reverse().toString().toCharArray();

        sb=new StringBuilder();
        int j=0;
        for(int i=0;i<string.length;i++){
            if(vowels.contains(string[i]))
                sb.append(vowelString[j++]);
            else
                sb.append(string[i]);
        }
        return sb.toString();
    }

    public static void main(String args[]){
        System.out.print(reverseVowels("ALpHa"));
    }
}
