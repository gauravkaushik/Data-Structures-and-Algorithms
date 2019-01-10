package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/word-ladder/
========================================================================

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5
Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0
Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

public class WordLadder {    
    
    //new approach : 2 way BFS : took 33ms
    //old approach : 1 way bfs took 107 ms
    public int ladderLength(String start, String end, List<String> dict) {
        Set<String> words = new HashSet<String>();
        for(String word : dict)
            words.add(word);
        if(!words.contains(end))
            return 0;
        return ladderLength(start, end, words);
    }
    
    public int ladderLength(String start, String end, Set<String> dict) {
        // bi-directional BFS
        Set<String> q1 = new HashSet<String>();
        Set<String> q2 = new HashSet<String>();
        
        q1.add(start);
        q2.add(end);
        dict.remove(end);
        
        int level=1;
        
        while(!q1.isEmpty() && !q2.isEmpty())
        {  
            Set<String> nextSet = new HashSet<String>();
            if(q1.size() > q2.size())
            {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            
            for(String word : q1)
            {
                //System.out.println("Current Word : "+word);
                char[] wordAry = word.toCharArray();
                for(int i=0; i<wordAry.length; i++)
                {
                    char old = wordAry[i];
                    for(char c='a'; c<='z'; c++)
                    {
                        wordAry[i] = c;
                        String newWord = new String(wordAry);
                        if(q2.contains(newWord))
                        {
                            //System.out.println("Matched Word : "+newWord);
                            return level+1;
                        }
                        if(!dict.contains(newWord))
                            continue;
                        //System.out.println("New Word : "+newWord);
                        dict.remove(newWord);
                        nextSet.add(newWord);
                    }
                    wordAry[i] = old;
                }
            }
            
            q1 = q2;
            q2 = nextSet;
            level++;
            //System.out.println("Level : "+level);
        }
        
        return 0;
    }
    
    
    //old approach : one way bfs took 107 ms
    public int ladderLengthOneWayBFS(String beginWord, String endWord, List<String> wordList) {
               
        //generate set of valid characters from wordList (advanced : get position wise charset)
        //create a queue of words and beginWord to it
        //pop a word from queue
        //generate all "valid" words at 1 mutation away from beginWord
        //if any of the valid word is the endWord, return current level
        //else add to queue
        //do while queue not empty
        
        Set<Character> charset = new HashSet<Character>();
        Set<String> bankSet = new HashSet<String>();
        for(String word : wordList)
        {
            bankSet.add(word);
            for(char c : word.toCharArray())
            {
                charset.add(c);
            }
        }
        
        if(!bankSet.contains(endWord))
            return 0;
        
        int level=0;
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- > 0)
            {
                String cur = q.poll();
                char[] word = cur.toCharArray();
                for(int i=0; i<word.length; i++)
                {
                    char old = word[i];
                    for(char c : charset)
                    {
                        word[i] = c;
                        String newWord = new String(word);
                        if(newWord.equals(endWord))
                            return level+2;
                        if(bankSet.contains(newWord))
                        {              
                            //System.out.println("New valid word is : "+newWord+" at level: "+level);
                            bankSet.remove(newWord); //kind of marking it as visited 
                            q.offer(newWord);
                        }
                    }
                    word[i] = old;
                }
            }
            level++;
        }
        return 0;   
        
    }
}