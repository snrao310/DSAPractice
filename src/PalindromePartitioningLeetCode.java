import java.util.ArrayList;
import java.util.List;

/**
 * Created by snrao on 12/29/16.
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 */
public class PalindromePartitioningLeetCode {

    public static List<List<String>> partition(String s) {
        List<List<String >> result=new ArrayList<>();
        backTrackFunction(result,new ArrayList<>(), s, 0);
        return result;
    }

    private static void backTrackFunction(List<List<String >> list, List<String> tempList, String s, int start){
        if(start==s.length()){
            list.add(new ArrayList<String>(tempList));
            return;
        }
        for (int i=start;i<s.length();i++){
            String sub=s.substring(start,i+1);
            if(isPalindrome(sub)){
                tempList.add(sub);
                backTrackFunction(list,tempList,s,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s){
        if(s.length()==1) return true;
        int i=0,j=s.length()-1;
        while (i<j && s.charAt(i)==s.charAt(j)){
            i++;j--;
        }
        if(s.charAt(i)==s.charAt(j))
            return true;
        return false;
    }

    public static void main(String args[]){
        List<List<String>> l=partition("aab");
        for(List<String> li:l){
            for(String s:li)
                System.out.print(s+" ");
            System.out.println();
        }    }
}
