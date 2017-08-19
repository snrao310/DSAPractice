/**
 * Created by S N Rao on 8/16/2017.
 *
 * Validate if a given string is numeric.
 *
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before
 * implementing one.
 *
 */
public class ValidNumberLeetCode2 {

    public static boolean isNumber(String s) {
        s=s.trim();
        boolean numberSeen=false, pointSeen=false, eSeen=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c))
                numberSeen=true;
            else if(c=='.'){
                if(eSeen || pointSeen) return false;
                pointSeen=true;
            }
            else if(c=='e'){
                if(!numberSeen || eSeen) return false;
                eSeen=true;
                numberSeen=false;
            }
            else if(c=='+' || c=='-'){
                if(i!=0 && s.charAt(i-1)!='e') return false;
                numberSeen=false;
            }
            else return false;
        }
        return numberSeen;
    }

    public static void main(String args[]){
        System.out.println(isNumber("   0.321")); //true
        System.out.println(isNumber("  -0.32e+67")); //true
        System.out.println(isNumber("  - 0.32e67e"));   //false
    }
}
