import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by S N Rao on 3/7/2017.
 *
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation
 * of the two words, i.e. words[i] + words[j] is a palindrome.
 *
 * Example 1:
 * Given words = ["bat", "tab", "cat"]
 * Return [[0, 1], [1, 0]]
 * The palindromes are ["battab", "tabbat"]
 *
 * Example 2:
 * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 *
 * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
 *
 */
public class PalindromePairsLeetCode {

    private static class TrieNode{
        HashMap<Character,TrieNode> children;
        boolean end; int index;
        List<Integer> indices;

        TrieNode(){
            children=new HashMap<>();
            indices=new ArrayList<>();
            index=-1;
        }
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        TrieNode root=new TrieNode();
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<words.length;i++)
            addToTrie(root,words,i);
        for(int i=0;i<words.length;i++)
            searchPal(root,words,i,result);
        return result;
    }

    private static void addToTrie(TrieNode root, String[] words, int index){
        String word=words[index];
        int i=0;
        while(i<word.length() && root.children.containsKey(word.charAt(i))) {
            root.indices.add(index);
            root = root.children.get(word.charAt(i++));
        }

        while(i<word.length()) {
            root.indices.add(index);
            root.children.put(word.charAt(i), new TrieNode());
            root = root.children.get(word.charAt(i++));
        }
        root.end=true;
        root.index=index;
    }

    private static void searchPal(TrieNode root, String[] words, int index, List<List<Integer>> list){
        char[] word=words[index].toCharArray();
        int d=0;

        //i=word.length is for null string case.
        for(int i=word.length;i>=0;i--){
            if(i!=word.length){
                if(root.children.containsKey(word[i])){
                    root=root.children.get(word[i]);
                    d++;
                }
                else break;
            }

            if(root.end && root.index!=index){
                if(isPalindrome(words[index].substring(0,i))) {
                    List<Integer> tuple=new ArrayList<>();
                    tuple.add(root.index); tuple.add(index);
                    list.add(tuple);
                }
            }

            if(i==0){
                for(int j: root.indices){
                    if(isPalindrome(words[j].substring(d))){
                        List<Integer> tuple=new ArrayList<>();
                        tuple.add(j); tuple.add(index);
                        list.add(tuple);
                    }
                }
            }
        }
    }

    private static boolean isPalindrome(String s){
        char[] str=s.toCharArray();
        for(int i=0;i<s.length()/2;i++){
            if(str[i]!=str[s.length()-i-1])
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        String[] strings={"abcd", "dcba", "lls", "s", "sssll","ll"};
        List<List<Integer>> list=palindromePairs(strings);
        for(List<Integer> l:list){
            System.out.print(l.get(0)+","+l.get(1)+" ");
        }
    }
}
