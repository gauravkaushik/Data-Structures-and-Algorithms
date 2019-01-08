package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/implement-trie-prefix-tree/
========================================================================

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

public class Trie {
    
    TrieNode root;
    

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode next = root;
        for(char c : word.toCharArray())
        {
            if(next.children[c-'a'] == null)
                next.children[c-'a'] = new TrieNode();
            next = next.children[c-'a'];
        }
        next.word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode next = root;
        for(char c : word.toCharArray())
        {
            if(next.children[c-'a'] == null)
                return false;
            next = next.children[c-'a'];
        }
        return next.word;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode next = root;
        for(char c : prefix.toCharArray())
        {
            if(next.children[c-'a'] == null)
                return false;
            next = next.children[c-'a'];
        }
        return true;
    }
    
    private class TrieNode
    {
        TrieNode[] children;
        boolean word;
        
        TrieNode()
        {
            children = new TrieNode[26];
            word = false;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
