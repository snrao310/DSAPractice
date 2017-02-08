import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by S N Rao on 2/8/2017.
 *
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American
 * keyboard.
 *
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 *
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 *
 */
public class KeyboardRowLeetCode {

    public static String[] findWords(String[] words) {
        HashSet<Character> row1=new HashSet<>();
        HashSet<Character> row2=new HashSet<>();
        HashSet<Character> row3=new HashSet<>();
        row1.add('q');row1.add('w');row1.add('e');row1.add('r');row1.add('t');row1.add('y');row1.add('u');row1.add('i');row1.add('o');row1.add('p');
        row2.add('a');row2.add('s');row2.add('d');row2.add('f');row2.add('g');row2.add('h');row2.add('j');row2.add('k');row2.add('l');
        row3.add('z');row3.add('x');row3.add('c');row3.add('v');row3.add('b');row3.add('n');row3.add('m');
        List<String> result=new ArrayList<>();
        for(String st: words){
            String s=st.toLowerCase();
            HashSet<Character> row=(row1.contains(s.charAt(0)))?row1:(row2.contains(s.charAt(0)))?row2:row3;
            int i=1;
            for(;i<s.length();i++){
                if(!row.contains(s.charAt(i))) break;
            }
            if(i==s.length()) result.add(st);
        }
        return result.toArray(new String[result.size()]);
    }

    public static void main(String[] args) {
        String[] res=findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for(String s: res)
            System.out.print(s+" ");
    }

}
