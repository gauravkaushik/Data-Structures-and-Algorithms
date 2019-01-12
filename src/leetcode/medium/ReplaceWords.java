package leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/replace-words/
========================================================================

In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.

Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.

You need to output the sentence after the replacement.

Example 1:
Input: dict = ["cat", "bat", "rat"]
sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Note:
The input will only have lower-case letters.
1 <= dict words number <= 1000
1 <= sentence words number <= 1000
1 <= root length <= 100
1 <= sentence words length <= 1000

**/

public class ReplaceWords {
    public String replaceWords(List<String> dict, String sentence) {
        //make a trie of all root words O(1000)
        //for each word in sentence, search for the shortest root word in the trie in O(100) and append it to result string
        //if not root found, append the original word to the list
        //Build : O(1000) + O(1000) * O(100) = O(10000)
        
        StringBuilder result = new StringBuilder();
        
        Trie trie = new Trie();
        for(String word : dict)
            trie.insert(word);
        
        String[] wordsAry = sentence.split(" ");
        
        String temp = trie.findSmallestRootWord(wordsAry[0]);
        result.append( temp!=null ? temp :  wordsAry[0]);
        
        for(int i=1; i<wordsAry.length; i++)
        {
            temp = trie.findSmallestRootWord(wordsAry[i]);
            result.append(" ");
            result.append( temp!=null ? temp :  wordsAry[i]);
        }
        
        return result.toString();
        
    }
    
    private class Trie
    {
        TrieNode root;
        Trie()
        {
            root = new TrieNode();
        }
        
        void insert(String word)
        {
            TrieNode next = root;
            char c;
            for(int i=0; i<word.length(); i++)
            {
                c = word.charAt(i);
                if(!next.children.containsKey(c))
                    next.children.put(c, new TrieNode());
                next = next.children.get(c);
            }
            next.isEnd = true;
        }
        
        String findSmallestRootWord(String word)
        {
            StringBuilder res = new StringBuilder();
            TrieNode next = root;
            char c;
            for(int i=0; i<word.length(); i++)
            {
                c = word.charAt(i);
                res.append(c);
                
                if(!next.children.containsKey(c))
                    return null;
                
                next = next.children.get(c);
                if(next.isEnd)
                    return res.toString();                
            }
            return null;
        }
    }
    
    private class TrieNode
    {
        boolean isEnd;
        Map<Character, TrieNode> children;
        TrieNode()
        {
            isEnd = false;
            children = new HashMap<>();
        }
    }
}