package leetcode.medium;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode next = root;
        for(char c : word.toCharArray())
        {
            if(!next.children.containsKey(c))
            {
                next.children.put(c, new TrieNode());
            }
            next = next.children.get(c);
        }
        next.isEnd = true;
    }
    
    public boolean search(String word)
    {
    	return search(word.toCharArray(), 0, root);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(char[] word, int idx, TrieNode startNode) {
        if(idx==word.length)
        	return startNode.isEnd;
    	
    	TrieNode next = startNode;
    	char c = word[idx];
    	if( c != '.' )
    	{
    		if( !next.children.containsKey(c) )
    			return false;
    		next = next.children.get(c);
    		return search(word, idx+1, next);    		
    	}
    	else
    	{
    		
    		Collection<TrieNode> children = next.children.values();
    		if(children==null || children.isEmpty())
    			return false;
    		for(TrieNode child : children)
    		{
    			if(search(word, idx+1, child))
    				return true;
    		}
    		
    		return false;
    			
    	}
    	
    }
    
    private class TrieNode
    {
        Map<Character, TrieNode> children;
        boolean isEnd;
        TrieNode()
        {
            isEnd = false;
            children = new HashMap<>();
        }
    }
    
    public static void main(String[] args) {
		WordDictionary dict = new WordDictionary();
		dict.addWord("bad");
		dict.addWord("dad");
		dict.addWord("mad");
		
		System.out.println(dict.search("."));
		System.out.println(dict.search(".."));
		System.out.println(dict.search("..."));
		System.out.println(dict.search("...."));
	}
    
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
 
 
 /**
 
 addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

*/