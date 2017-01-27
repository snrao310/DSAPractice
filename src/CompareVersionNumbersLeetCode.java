/**
 * Created by S N Rao on 1/26/2017.
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 *
 */
public class CompareVersionNumbersLeetCode {

    //Easy way is to split and convert each part to integer and compare.
    // Not converting to integer from string coz assuming the string can be too long for integer representation.
    public static int compareVersion(String version1, String version2) {
        String[] split1=version1.split("\\."); //"." means any character in regular expression. So we must use "\\."
        String[] split2=version2.split("\\.");

        String v1=split1[0];
        String v2=split2[0];

        //Remove leading zeroes
        int i=0;
        while(i<v1.length() && v1.charAt(i)=='0') i++;
        v1=(i==v1.length())?"0":v1.substring(i);
        i=0;
        while(i<v2.length() && v2.charAt(i)=='0') i++;
        v2=(i==v2.length())?"0":v2.substring(i);

        if(v1.length()>v2.length()) return 1;
        if(v2.length()>v1.length()) return -1;
        for(i=0;i<v1.length();i++){
            if(v1.charAt(i)>v2.charAt(i)) return 1;
            if(v2.charAt(i)>v1.charAt(i)) return -1;
        }
        if(split1.length>1 || split2.length>1) {
            String one=(split1.length>1)?version1.substring(split1[0].length() + 1):"0";
            String two=(split2.length>1)?version2.substring(split2[0].length() + 1):"0";
            return compareVersion(one, two);
        }
        return 0;
    }

    public static void main(String args[]){
        System.out.println(compareVersion("1.1.1","1.01.1"));
//        System.out.println(compareVersion("1.0","1"));
    }
}
