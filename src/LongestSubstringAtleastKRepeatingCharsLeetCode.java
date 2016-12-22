/**
 * Created by snrao on 12/21/16.
 *
 * Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every
 * character in T appears no less than k times.
 *
 */
public class LongestSubstringAtleastKRepeatingCharsLeetCode {

    public static int longestSubstring(String s, int k) {
        char[] string=s.toCharArray();
        return recursiveFunction(string,k,0,s.length());
    }


    //quicksort pivot type method.
    public static int recursiveFunction(char[] s, int k, int start, int end){
        if(end-start < k)return 0;
        int[] count=new int[26];
        for(int i=start;i<end;i++){
            int index=s[i]-'a';
            count[index]++;
        }

        for(int i=0;i<26;i++){            //This loop is not really required. Its just for randomizing the partition.
            if(count[i]>0 && count[i]<k){   //if we don't use the above loop, we will just send this line below into the next loop.
                for(int j=start;j<end;j++){
                    if(s[j]==i+'a'){
                        int left=recursiveFunction(s,k,start,j);
                        int right=recursiveFunction(s,k,j+1,end);
                        return Math.max(left,right);
                    }
                }
            }
        }
        return end-start;
    }


    public static void main(String args[]) {
        System.out.println(longestSubstring("aaabb", 3));
    }
}
