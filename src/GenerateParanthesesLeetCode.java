import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/12/16.
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * ((()))
 * (()())
 * (())()
 * ()(())
 * ()()()
 */
public class GenerateParanthesesLeetCode {

    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();

        backTrackFunction(result,new String(), n, 0,0);

        return result;
    }

    public static void backTrackFunction(List<String> list, String tempString,
                                         int max, int open, int close){
        if(tempString.length()==2*max){
            list.add(tempString);
            return;
        }
        if(open<max){
            backTrackFunction(list, tempString+'(',max,open+1,close); //Don't need to change the string back since its immutable.
        }
        if(close<open){
            backTrackFunction(list, tempString+')',max,open,close+1); //Don't need to change the string back since its immutable.
        }
    }


    public static void main(String args[]) {
        List<String> list = generateParenthesis(3);

        for (String k : list) {
            System.out.println(k);
        }

    }
}
