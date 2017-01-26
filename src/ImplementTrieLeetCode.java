import java.util.HashMap;

/**
 * Created by S N Rao on 1/17/2017.
 * <p>
 * Implement a trie with insert, search, and startsWith methods.
 * <p>
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrieLeetCode {

    static class TrieNode {
        // Initialize your data structure here.
        HashMap<Character, TrieNode> children;
        boolean end;

        public TrieNode() {
            children = new HashMap<>();
            end = false;
        }
    }

    public static class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode t = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!t.children.containsKey(c))
                    t.children.put(c, new TrieNode());
                t = t.children.get(c);
            }
            t.end = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode t = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!t.children.containsKey(c))
                    return false;
                t = t.children.get(c);
            }
            return t.end;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode t = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (!t.children.containsKey(c))
                    return false;
                t = t.children.get(c);
            }
            return true;
        }
    }

    public static void main(String args[]) {
        // Your Trie object will be instantiated and called as such:
        Trie trie = new Trie();
        trie.insert("Sameeran");
        trie.insert("Medha");
        trie.insert("Varchas");
        System.out.println(trie.search("Sam"));
        trie.insert("Sam");
        System.out.println(trie.search("Sam"));
        System.out.println(trie.search("Sameerana"));
        System.out.println(trie.search("Sameeran"));
        System.out.println(trie.search("Medha"));
        System.out.println(trie.startsWith("Sam"));
        System.out.println(trie.startsWith("Va"));
        System.out.println(trie.startsWith("Varchas"));

    }
}
