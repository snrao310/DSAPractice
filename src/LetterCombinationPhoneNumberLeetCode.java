import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by snrao on 12/9/16.
 * <p>
 * Given a digit string, return all possible letter combinations that the number could represent.
 */
public class LetterCombinationPhoneNumberLeetCode {

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, List<String>> map = new HashMap<>();
        if(digits.equals(""))
            return new ArrayList();

        for (int i = 2; i < 10; i++) {
            List<String> s=new ArrayList<>();
            if(i<7)
                for (int j = 0; j < 3; j++)
                    s.add(Character.toString((char) (j + 97 + (i - 2) * 3)));
            if(i==7) {
                for (int j = 0; j < 4; j++)
                    s.add(Character.toString((char) (j + 97 + (i - 2) * 3)));
            }
            if(i==8) {
                for (int j = 0; j < 3; j++)
                    s.add(Character.toString((char) (j + 98 + (i - 2) * 3)));
            }
            if(i==9) {
                for (int j = 0; j < 4; j++)
                    s.add(Character.toString((char) (j + 98 + (i - 2) * 3)));
            }
            map.put(i,s);
        }

        int number=Character.getNumericValue(digits.charAt(0));
        List<String> comb=new ArrayList(map.get(number));
        for(int i=1;i<digits.length();i++){
            List<String> letters = new ArrayList(map.get(Character.getNumericValue(digits.charAt(i))));
            int len=comb.size();
            for(int j=0; j<len; j++){
                String s=comb.get(0);
                int limit=3;
                if(Character.getNumericValue(digits.charAt(i))==9 || Character.getNumericValue(digits.charAt(i))==7)
                    limit=4;
                for(int k=0;k<limit;k++)
                    comb.add(s+letters.get(k));
                comb.remove(0);
            }
        }
        return comb;
    }

    public static void main(String args[]) {

            List c=letterCombinations("999");
    }
}
