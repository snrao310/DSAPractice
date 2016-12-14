import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by snrao on 12/13/16.
 */
public class DifferentWaysAddParanthesesLeetCode {

    public static List<Integer> diffWaysToCompute(String input) {
        return dynamicHelper(input,new HashMap<>());
    }

    //Top-Down dynamic programming. Bottom up can't be used array is filled based on string. To remove dynamic
    //programming, we just need to remove two lines. Will still work.
    public static List<Integer> dynamicHelper(String input,HashMap<String,List<Integer>> map){
        if(map.containsKey(input))  //dynamic programming step
            return map.get(input);
        if(!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            if(input.length()>0)
                return new ArrayList(Arrays.asList(Integer.parseInt(input)));
            else
                return new ArrayList<>();
        }

        List<Integer> result=new ArrayList<>();
        for(int i=0;i<input.length();i++){
            char operator=input.charAt(i);
            if(operator!='+' && operator!='-' && operator!='*')
                continue;

            List<Integer> left=dynamicHelper(input.substring(0,i),map);
            List<Integer> right=dynamicHelper(input.substring(i+1),map);

            for(int x:left){
                for(int y:right){
                    switch (operator){
                        case '+': result.add(x+y);
                            break;
                        case '-': result.add(x-y);
                            break;
                        case '*': result.add(x*y);
                    }
                }
            }
        }
        map.put(input,result); //dynamic programming step
        return result;
    }

    public static void main(String args[]){
        List<Integer> l=diffWaysToCompute("2*3-4*5");
        for(int i:l)
            System.out.println(i);
    }
}
