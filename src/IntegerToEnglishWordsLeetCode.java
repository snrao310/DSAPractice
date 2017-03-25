import java.util.HashMap;

/**
 * Created by S N Rao on 3/24/2017.
 *
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 -1.
 *
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 */
public class IntegerToEnglishWordsLeetCode {

    //3 digit split. print what the 3 digits say then print exponent and go to next 3 digit part.
    public static String numberToWords(int num) {
        if(num==0) return "Zero";
        HashMap<Integer,String> numMap=new HashMap<>();
        HashMap<Integer,String> expMaps=new HashMap<>();
        fillMaps(numMap,expMaps);

        long k=1000; int exp=0;
        while(k<=num){
            k*=1000;
            exp++;
        }
        int div=(int)Math.pow(1000,exp);
        StringBuilder res=new StringBuilder();
        while(num>0){
            int threeDigits=num/div;
            num %= div;
            if(threeDigits!=0) {
                res.append(" " + threeDigitToWords(threeDigits, numMap));
                if (div != 1) res.append(" " + expMaps.get(div));
            }
            div /= 1000;
        }
        return res.substring(1).toString();
    }

    private static String threeDigitToWords(int k, HashMap<Integer,String> numMap){
        if(numMap.containsKey(k)) return numMap.get(k);
        if(k<100)
            return numMap.get(k-(k%10))+" "+numMap.get(k%10);
        else {
            if(k%100!=0) return numMap.get(k/100)+" Hundred "+threeDigitToWords(k%100,numMap);
            else return numMap.get(k/100)+" Hundred";
        }
    }

    private static void fillMaps(HashMap<Integer,String> numMap,HashMap<Integer,String> expMap){
        numMap.put(1,"One"); numMap.put(2,"Two"); numMap.put(3,"Three"); numMap.put(4,"Four"); numMap.put(5,"Five");
        numMap.put(6,"Six"); numMap.put(7,"Seven"); numMap.put(8,"Eight"); numMap.put(9,"Nine"); numMap.put(10,"Ten");
        numMap.put(11,"Eleven"); numMap.put(12,"Twelve"); numMap.put(13,"Thirteen"); numMap.put(14,"Fourteen");
        numMap.put(15,"Fifteen"); numMap.put(16,"Sixteen"); numMap.put(17,"Seventeen"); numMap.put(18,"Eighteen");
        numMap.put(19,"Nineteen"); numMap.put(20,"Twenty"); numMap.put(30,"Thirty"); numMap.put(40,"Forty");
        numMap.put(50,"Fifty"); numMap.put(60,"Sixty"); numMap.put(70,"Seventy"); numMap.put(80,"Eighty");
        numMap.put(90,"Ninety");
        expMap.put(1000,"Thousand"); expMap.put(1000000,"Million"); expMap.put(1000000000,"Billion");
    }


    public static void main(String args[]){
        System.out.println(numberToWords(123456));
        System.out.println(numberToWords(123000001));
        System.out.println(numberToWords(1000));
        System.out.println(numberToWords(13));
        System.out.println(numberToWords(1023010));
    }
}
