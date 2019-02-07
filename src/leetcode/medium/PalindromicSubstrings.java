package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/palindromic-substrings/
========================================================================

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
 

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 

Note:

The input string length won't exceed 1000.
*/

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        
        if(s==null || s.length()==0)
            return 0;
        
        int N = s.length();
        boolean[][] isPalindrome = new boolean[N][N];
        
        int distinctPalindromes = 0;
        for(int i=0; i<N; i++)
        {
            isPalindrome[i][i] = true;
            distinctPalindromes++;
        }
        
        for(int i=N-2; i>=0; i--)
        {
            for(int j=i+1; j<N; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    if(j==i+1 || isPalindrome[i+1][j-1])
                    {
                        isPalindrome[i][j] = true;
                        distinctPalindromes++;
                    }
                }
            }
        }
        
        return distinctPalindromes;
        
    }
}

/**
Note : can also be solved using the expand across centre approach
*/