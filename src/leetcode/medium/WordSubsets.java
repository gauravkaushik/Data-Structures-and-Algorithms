package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/word-subsets/
========================================================================

We are given two arrays A and B of words.  Each word is a string of lowercase letters.

Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".

Now say a word a from A is universal if for every b in B, b is a subset of a. 

Return a list of all universal words in A.  You can return the words in any order.

 

Example 1:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
Output: ["facebook","google","leetcode"]

Example 2:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
Output: ["apple","google","leetcode"]

Example 3:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
Output: ["facebook","google"]

Example 4:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
Output: ["google","leetcode"]

Example 5:
Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo"]
Output: ["facebook","leetcode"]
 

Note:
1 <= A.length, B.length <= 10000
1 <= A[i].length, B[i].length <= 10
A[i] and B[i] consist only of lowercase letters.
All words in A[i] are unique: there isn't i != j with A[i] == A[j].

*/

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        
        int[] table = new int[26];
        
        //table contains the maximum frequency with which each character can appear in any word of B
        buildTable(B, table);
        
        int[] temp = new int[26];
        
        l1:
        for(String a : A)
        {
            Arrays.fill(temp, 0);
            for(int i=0; i<a.length(); i++)
            {
                temp[a.charAt(i) - 'a']++;
            }
            
            //if the word 'a' contains any character with less frequency then as required by any word of B, ignore it
            for(int i=0; i<26; i++)
            {
                if(temp[i] < table[i])
                    continue l1;
            }
            result.add(a);            
        }
        return result;
              
    }
    
    private void buildTable(String[] B, int[] table)
    {        
        int j;
        for(String b : B)
        {
            int[] temp = new int[26];
            for(int i=0; i<b.length(); i++)
            {
                j = b.charAt(i) - 'a';
                temp[j]++;
                table[j] = Math.max(table[j], temp[j]);
            }
        }
    }
}