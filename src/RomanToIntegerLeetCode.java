import java.util.HashMap;

/**
 * Created by S N Rao on 3/28/2017.
 *
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 */
public class RomanToIntegerLeetCode {

    private static class Map{
        public HashMap<Character,Integer> convert;
        public Map(){
            convert=new HashMap<>();
            convert.put('I',1); convert.put('V',5); convert.put('X',10); convert.put('L',50);
            convert.put('C',100);convert.put('D',500);convert.put('M',1000);
        }
    }
    static Map map=new Map();

    public static int romanToInt(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return map.convert.get(s.charAt(0));
        int current=map.convert.get(s.charAt(0)), i=1;
        char c=s.charAt(1);
        while(map.convert.get(c)>current){
            current=map.convert.get(c)-current;
            if(++i==s.length()) break;
            c=s.charAt(i);
        }
        if(i!=s.length()){
            current+=romanToInt(s.substring(i));
        }
        return current;
    }

    public static void main(String args[]){
        System.out.print(romanToInt("CMXLV"));
    }
}
