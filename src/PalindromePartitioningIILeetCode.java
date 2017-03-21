/**
 * Created by S N Rao on 3/21/2017.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioningIILeetCode {

    //O(n^2) space and O(n^2) time. Create isPal matrix where isPal[i][j] is true if substring i to j is palindrome.
    //Then fill minCut array, where minCuts[i] is minCuts required for substring 0 to i, to make all parts palindrome.
    public static int minCut(String s) {
        int len=s.length();
        boolean[][] isPal=new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(i==j) isPal[i][j]=true;
                else if(j==i+1) isPal[i][j]= (s.charAt(i)==s.charAt(j));
                else isPal[i][j]=isPal[i+1][j-1] && s.charAt(i)==s.charAt(j);
            }
        }

        int[] minCuts=new int[len+1];
        minCuts[0]=-1;
        for(int i=1;i<len+1;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<=i;j++){
                if(isPal[j-1][i-1])
                    min=Math.min(min,minCuts[j-1]+1);
            }
            minCuts[i]=min;
        }
        return minCuts[len];
    }

    //O(n^2) time and O(n) space. minCuts[i] is minCuts required for substring 0 to i, to make all parts palindrome.
    //For each character, expand right and left to find largest palindrome with the character as center, then update value
    //of mincuts array for the rightmost index of the palindrome.
    public static int minCutBetter(String s){
        int len=s.length();
        int[] minCuts=new int[len+1];
        for(int i=0;i<len+1;i++){
            minCuts[i]=i-1;
        }

        for(int i=0;i<len;i++){
            // odd length palindrome
            for(int j=0; i+j<len && i-j>=0 && s.charAt(i+j)==s.charAt(i-j); j++){
                minCuts[i+j+1]=Math.min(minCuts[i+j+1],1+minCuts[i-j]);
            }

            // even length palindrome
            for(int j=1; i+j<len && i-j+1>=0 && s.charAt(i+j)==s.charAt(i-j+1); j++){
                minCuts[i+j+1]=Math.min(minCuts[i+j+1],1+minCuts[i-j+1]);
            }
        }
        return minCuts[len];
    }

    public static void main(String args[]){
        System.out.println(minCut("aabaaklk"));
    }
}
