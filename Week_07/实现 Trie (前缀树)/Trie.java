package cn.zwq.algorithm.middle;

/**
 * 208. 实现 Trie (前缀树)
 *
 * @author G20200343200113
 */
public class Trie {

    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
        }
    }

    /**
     * Initialize your data structure here.
     */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.child[c - 'a'] == null) {
                p.child[c - 'a'] = new TrieNode();
            }
            p = p.child[c - 'a'];
        }
        p.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        return p.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (p.child[c - 'a'] == null) {
                return false;
            }
            p = p.child[c - 'a'];
        }
        return true;
    }
}
