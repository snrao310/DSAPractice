import java.util.ArrayList;
import java.util.List;

/**
 * Created by S N Rao on 2/24/2017.
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 *
 */
public class ExpressionAddOperatorsLeetCode {

    public static List<String> addOperators(String num, int target) {
        List<String> result=new ArrayList<>();
        backTrackFunction(num, 0, target, result, "", 0,0);
        return result;
    }

    private static void backTrackFunction(String s, int pos, int target, List<String> list, String tempString, long eval, long prev){
        if(pos==s.length()){
            if(eval==target)
                list.add(tempString);
            return;
        }

        for(int i=pos;i<s.length();i++){
            if(s.charAt(pos)=='0' && i!=pos) break;
            long cur=Long.parseLong(s.substring(pos,i+1));
            if(pos==0){
                backTrackFunction(s,i+1,target,list,Long.toString(cur),cur,cur);
            }

            else {
                String thisPart = tempString + "+" + cur;
                backTrackFunction(s,i+1, target, list, thisPart, eval+cur, cur);

                thisPart = tempString + "-" + cur;
                backTrackFunction(s,i+1, target, list, thisPart, eval-cur, -cur);

                thisPart = tempString + "*" + cur;
                backTrackFunction(s,i+1, target, list, thisPart, eval-prev+prev*cur,prev*cur);
            }
        }
    }

    public static void main(String args[]){
        List<String> list=addOperators("105",5);
        for(String l:list)
            System.out.println(l);
    }
}
