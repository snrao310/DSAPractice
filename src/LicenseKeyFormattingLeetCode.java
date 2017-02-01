/**
 * Created by S N Rao on 2/1/2017.
 *
 * Now you are given a string S, which represents a software license key which we would like to format. The string S is
 * composed of alphanumerical characters and dashes. The dashes split the alphanumerical characters within the string
 * into groups. (i.e. if there are M dashes, the string is split into M+1 groups). The dashes in the given string are
 * possibly misplaced.
 *
 * We want each group of characters to be of length K (except for possibly the first group, which could be shorter, but
 * still must contain at least one character). To satisfy this requirement, we will reinsert dashes. Additionally, all
 * the lower case letters in the string must be converted to upper case.
 *
 * So, you are given a non-empty string S, representing a license key to format, and an integer K. And you need to
 * return the license key formatted according to the description above.
 *
 * Note:
 * The length of string S will not exceed 12,000, and K is a positive integer.
 * String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 * String S is non-empty.
 *
 */
public class LicenseKeyFormattingLeetCode {

    public static String licenseKeyFormatting(String S, int K) {
        String result="",str="";
        for(int i=S.length()-1;i>=0;i--){
            char c=S.charAt(i);
            if(c=='-' && i!=0) continue;
            if(c!='-') str+=c;
            if(str.length()==K || (str.length()>0 && i==0)){
                if(result.length()!=0) result+='-';
                result+=str;
                str="";
            }
        }
        return new StringBuilder(result).reverse().toString().toUpperCase();
    }

    public static void main(String args[]){
        System.out.println(licenseKeyFormatting("2-4A0r7-4k",3));
        System.out.println(licenseKeyFormatting("2-4A0r7-4k",4));
    }
}
