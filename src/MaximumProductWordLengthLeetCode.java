/**
 * Created by snrao on 12/10/16.
 *
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words
 * do not share common letters. You may assume that each word will contain only lower case letters. If no such
 * two words exist, return 0.
 */
public class MaximumProductWordLengthLeetCode {

    public static int maxProduct(String[] words) {
        int max=0;
        int values[]=new int[words.length];

        //Create value element for each word which depends on which letters exist in the word. If 'a' appears in the
        //word, we set bit 1st bit (LSB), if 'b' appears, we set 2nd bit, if 'z' appears, we set 26th bit.
        for(int i=0;i<words.length;i++){
            String str=words[i];
            for(int j=0;j<str.length();j++){
                values[i] |= (1 << (str.charAt(j)-'a') );
            }
        }

        //we check if any pair of words are free of common bits by doing bitwise AND and seeing if its 0.
        for(int i=0;i<words.length-1;i++){
            for(int j=i+1;j<words.length;j++){
                if((values[i] & values[j])==0 && (words[i].length()*words[j].length() > max)){
                    max=words[i].length()*words[j].length();
                }
            }
        }

        return max;
    }

    public static void main(String args[]){
        String[] a={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.print(maxProduct(a));
    }

}
