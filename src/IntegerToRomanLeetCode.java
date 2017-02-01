import java.util.HashMap;

/**
 * Created by S N Rao on 2/1/2017.
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class IntegerToRomanLeetCode {

    //O(number of digits) =O(logn) to the base 10.
    public static String intToRoman(int num) {
        int nearest[]={0,0,0,0,5,5,5,5,5,10,10};
        HashMap<Integer,String> symbols=new HashMap<>();
        symbols.put(1, "I"); symbols.put(5, "V");
        symbols.put(10, "X"); symbols.put(50, "L");
        symbols.put(100, "C"); symbols.put(500, "D");
        symbols.put(1000, "M"); symbols.put(0,"");
        String result="";

        int pow=1;
        while(num>0){
            int c=(num%10), near=nearest[c];;
            num/=10;
            if(c==0) {pow*=10; continue;}
            String str="";
            while(c<near){
                c++;
                str+=symbols.get(pow);
            }
            str+=symbols.get(near*pow);
            while(c>near){
                str+=symbols.get(pow);
                c--;
            }
            result=str+result;      //Can put it in stack and join later for faster execution.
            pow*=10;
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(intToRoman(10));
    }
}
