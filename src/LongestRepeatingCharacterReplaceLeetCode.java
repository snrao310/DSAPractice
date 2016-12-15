/**
 * Created by S N Rao on 12/14/2016.
 *
 * Given a string that consists of only uppercase English letters, you can replace any letter in the string with
 * another letter at most k times. Find the length of a longest substring containing all repeating letters you can
 * get after performing the above operations.
 */
public class LongestRepeatingCharacterReplaceLeetCode {

    //Using sliding window
    public static int characterReplacement(String s, int k) {
        int result=0;

        for(int letterNum=65;letterNum<(65+26);letterNum++){
            char letter=(char)letterNum;
            int i=0,j=0,max=0,curr=0,other=0;
            while(j<s.length()){
                if(s.charAt(j)!=letter){
                    if(other<k){
                        other++;
                        curr++;
                    }
                    else{
                        while(s.charAt(i)==letter){
                            i++;
                            curr--;
                        }
                        i++;
                    }
                }

                else
                    curr++;

                if(curr>max)
                    max=curr;
                j++;
            }
            if(max>result)
                result=max;
        }

        return result;
    }

    public static void main(String args[]){
        System.out.print(characterReplacement("AAABBBAABAAAAAAAAA",3));
    }
}
