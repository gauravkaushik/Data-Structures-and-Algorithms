package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/word-search/
========================================================================

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        //for each point in board where the first letter of word is present
            //search for the word using dfs
        
        if(board==null || board.length==0 || board[0].length==0)
            return false;
        
        if(word==null || word.length()==0)
            return true;      
        
        int m = board.length;
        int n = board[0].length;        
        
        if(word.length() > m*n)
            return false;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {                
                if(dfs_search(i, j, board, word, 0, visited))
                {
                    return true;
                }
            }
        }
        
        return false;        
    }
    
    private boolean dfs_search(int i, int j, char[][] board, String word, int idx, boolean[][] visited)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;
        
        if(visited[i][j])
            return false;       
        
        if(board[i][j]!=word.charAt(idx))
            return false;
        
        if(idx==word.length()-1)
            return true;
        
        visited[i][j] = true;
        
        boolean result =  ( dfs_search(i-1, j, board, word, idx+1, visited) || dfs_search(i+1, j, board, word, idx+1, visited) || dfs_search(i, j-1, board, word, idx+1, visited) || dfs_search(i, j+1, board, word, idx+1, visited)  ); 
        
        visited[i][j] = false;
        
        return result;
        
        
        
    }
}