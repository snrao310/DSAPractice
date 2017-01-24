import java.util.HashMap;

/**
 * Created by S N Rao on 1/24/2017.
 *
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it
 * can represent any one letter.
 *
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 */
public class AddAndSearchWordDataStructureDesignLeetCode {

    public static class WordDictionary {

        public class TrieNode{
            boolean end;
            HashMap<Character,TrieNode> children;
            public TrieNode(){end=false;children=new HashMap<>();}
        }

        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root=new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode t=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!t.children.containsKey(ch))
                    t.children.put(ch, new TrieNode());
                t=t.children.get(ch);
            }
            t.end=true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchBackTrack(word,root);
        }

        private boolean searchBackTrack(String word, TrieNode t){
            if(word.length()==0) return t.end;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(ch=='.'){
                    for(char c:t.children.keySet()){
                        String nextWord=(i==word.length()-1)?"":word.substring(i+1);
                        if(searchBackTrack(nextWord,t.children.get(c)))
                            return true;
                    }
                    return false;
                }
                else{
                    if(t.children.containsKey(ch))
                        t=t.children.get(ch);
                    else return false;
                }
            }
            return t.end;
        }
    }

    public static void main(String args[]){
        WordDictionary obj = new WordDictionary();
        obj.addWord("abc");
        obj.addWord("cab");
        obj.addWord("samy");
        System.out.println(obj.search("..c"));
        System.out.println(obj.search("abc"));
        System.out.println(obj.search(".am.."));
    }
}
