/**
 * Created by S N Rao on 4/3/2017.
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
public class ValidNumberLeetCode {

    public static boolean isNumber(String s) {
        s=s.trim();
        boolean numberSeen=false, eSeen=false, pointSeen=false, numberAfterE=false;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                numberSeen=true;
            }
            else if(c=='.'){
                if(pointSeen || eSeen)
                    return false;
                pointSeen=true;
            }
            else if(c=='e'){
                if(eSeen || !numberSeen)
                    return false;
                eSeen=true;
                numberSeen=false;
            }
            else if(c=='-' || c=='+'){
                if(i!=0 && s.charAt(i-1)!='e')
                    return false;
            }
            else
                return false;
        }

        return numberSeen;
    }

    public static void main(String args[]){
        System.out.println(isNumber("   0.321")); //true
        System.out.println(isNumber("  -0.32e+67")); //true
        System.out.println(isNumber("  - 0.32e67e"));   //false
    }
}
