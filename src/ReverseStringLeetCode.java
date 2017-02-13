/**
 * Created by S N Rao on 2/12/2017.
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 *
 */
public class ReverseStringLeetCode {

    public static String reverseString(String s) {
        //can always do return new StringBuilder(s).reverse().toString();
        char[] arr=s.toCharArray();
        int n=arr.length, goTill=n/2 - 1;
        for(int i=0;i<=goTill;i++){
            char temp=arr[i];
            arr[i]=arr[n-1-i];
            arr[n-1-i]=temp;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("abcdefgh"));
    }
}