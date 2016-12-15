/**
 * Created by S N Rao on 12/14/2016.
 *
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 */
public class DecodeStringLeetCode {

    //Recursive solution. No need of a specific base case. Base case will just execute the else part inside loop.
    public static String decodeString(String s) {
        String result="";

        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                int j=i;
                while(s.charAt(i)!='[')
                    i++;
                int k = Integer.parseInt(s.substring(j,i));
                j=i+1;
                int brackets=1;
                while(brackets!=0){
                    i++;
                    if(s.charAt(i)=='[')
                        brackets++;
                    else if(s.charAt(i)==']')
                        brackets--;
                }
                String partial=decodeString(s.substring(j,i));
                for(j=0;j<k;j++)
                    result+=partial;
            }

            //Base case executes only this. But base case is not the only case that executes this.
            else
                result+=s.charAt(i);
        }
        return result;
    }

    public static void main(String args[]){
        System.out.print(decodeString("2[abc]3[cd]ef"));
    }
}
