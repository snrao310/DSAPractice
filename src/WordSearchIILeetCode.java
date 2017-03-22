import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by S N Rao on 3/22/2017.
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 *
 * [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 */
public class WordSearchIILeetCode {

    public static class TrieNode{
        boolean end=false;
        int index=-1;
        HashMap<Character,TrieNode> children;

        public TrieNode(){
            children=new HashMap<>();
        }
    }


    //Backtracking with trie. Awesome.
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res=new ArrayList<>();
        TrieNode root=buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backtrackFunction(board, i, j, root, words, res);
            }
        }
        return res;
    }

    private static TrieNode buildTrie(String[] words){
        TrieNode root=new TrieNode();
        for(int k=0;k<words.length;k++){
            TrieNode temp=root;
            char[] s=words[k].toCharArray();
            int i=0;
            for(i=0;i<s.length;i++){
                HashMap children= temp.children;
                if(children.containsKey(s[i]))
                    temp=temp.children.get(s[i]);
                else break;
            }
            while (i<s.length){
                temp.children.put(s[i],new TrieNode());
                temp=temp.children.get(s[i]);
                i++;
            }
            temp.end=true; temp.index=k;
        }
        return root;
    }

    private static void backtrackFunction(char[][] board, int i, int j, TrieNode root, String[] words, List<String> res){
        if(root.end){
            res.add(words[root.index]);
            root.end=false;
        }

        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return;

        if(root.children.containsKey(board[i][j])){
            TrieNode nextRoot=root.children.get(board[i][j]);
            char c=board[i][j];
            board[i][j]='#';
            backtrackFunction(board,i+1,j,nextRoot,words,res);
            backtrackFunction(board,i-1,j,nextRoot,words,res);
            backtrackFunction(board,i,j+1,nextRoot,words,res);
            backtrackFunction(board,i,j-1,nextRoot,words,res);
            board[i][j]=c;
        }
    }


    public static void main(String args[]){
        char[][] board=new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        List<String> list=findWords(board,new String[]{"oath","pea","eat","rain"});
        for(String s: list)
            System.out.print(s+" ");
    }
}
