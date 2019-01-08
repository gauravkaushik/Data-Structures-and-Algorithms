package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/word-search-ii/
========================================================================

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]

Note:
You may assume that all inputs are consist of lowercase letters a-z.

*/

//Old approach : For each word, did DFS from all possible positions of the board : Took : 485ms
//New approach : Do DFS of the board only once. But while doing so, lookup into trie to find matching words and add them to the result list. Also, fail as soon as you find a character that cannot form any word in the trie. Took 26ms
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        //build a trie from the given list of words
        //from each position in board, try to form all possible words using dfs and add to result if it exists in the trie
        //Note : while doing dfs, exit early if the next character (neighbor) cannot form any word
        
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                dfs(i, j, board, root, res);
            }
        }
        
        return res;
    }
    
    void dfs(int i, int j, char[][] board, TrieNode root, List<String> res)
    {
        //System.out.println("i,j,board[i][j] : "+i+", "+j+", "+board[i][j]);
        if(board[i][j]=='A')
        	return;
        
        int c = board[i][j] - 'a';
        TrieNode next = root.children[c];
        if(next == null) //no word possible in the trie with current board character as the next character
            return;
        if(next.word!=null) //found a word
        {
            res.add(next.word);
            next.word = null; //as we want unique words only
        }
        
        char prev = board[i][j];
        board[i][j] = 'A';
        if(i > 0)   dfs(i-1,j,board,next,res);
        if(i<board.length-1)    dfs(i+1,j,board,next,res);
        if(j>0) dfs(i,j-1,board,next,res);
        if(j<board[0].length-1) dfs(i,j+1,board,next,res);
        
        board[i][j] = prev;
    }
    
    TrieNode buildTrie(String[] words)
    {
        TrieNode root = new TrieNode();
        
        for(String word : words)
        {
            TrieNode next = root;
            for(char c : word.toCharArray())
            {
                if(null == next.children[c-'a'])                
                    next.children[c-'a'] = new TrieNode();                                    
                next = next.children[c-'a'];
            }
            next.word = word;
        }
        
        return root;
    }
    
    private class TrieNode
    {
        TrieNode children[];
        String word;
        TrieNode()
        {
            children = new TrieNode[26];
        }
    }
}

/***
//Old approach : For each word, did DFS from all possible positions of the board : Took : 485ms
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> matchedWords = new ArrayList<>();
        
        if(board==null || board.length==0 || board[0].length==0 || words==null || words.length==0)
            return matchedWords;
        
        
        //remove duplicate words from input list of words
        Set<String> hs = new HashSet<>();
        for(String word : words)
            hs.add(word);        
        
        for(String word : hs)
        {
            if(helper(board, word))
                matchedWords.add(word);
        }
        
        return matchedWords;
    }
    
    private boolean helper(char[][] board, String word)
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(dfs(i,j,board,word,0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, char[][] board, String word, int idx)
    {
        if(idx==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;        
        if(board[i][j]!=word.charAt(idx))
            return false;
        
        board[i][j] ^= 256;
        boolean exist = (dfs(i-1,j,board,word,idx+1) ||  dfs(i+1,j,board,word,idx+1) || dfs(i,j-1,board,word,idx+1) || dfs(i,j+1,board,word,idx+1));
        //System.out.println("i,j,exist : "+i+", "+j+", "+ exist);
        board[i][j] ^= 256;
        return exist;
        
    }
}

**/