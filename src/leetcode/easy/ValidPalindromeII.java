package leetcode.easy ;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/valid-palindrome-ii/
========================================================================

Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True

Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
*/

public class ValidPalindromeII {
    
    //try deleting each character and check if remaining string is a palindrome or not 
    //O(n) * O(n) = O(n^2)
    public boolean validPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;
        
        StringBuilder sb = new StringBuilder(s);
        
        if(isValidPalindrome(sb))
            return true;
        
        for(int i=0; i<s.length(); i++)
        {
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            if( isValidPalindrome(sb) )
                return true;
            sb.insert(i, c);
        }
        
        return false;
    }
    
    private boolean isValidPalindrome(StringBuilder sb)
    {
        int i = 0, j = sb.length() - 1;
        while(i < j)
        {
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++; j--;
        }
        return true;
    }
}

/*
A one pass algorithm using O(1) extra space from https://leetcode.com/problems/valid-palindrome-ii/discuss/209252/Java-Python-Two-Pointers-with-Thinking-Process:
public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }

        return true;
    }
    
    // Check if s[i...j] is palindrome. 
    private boolean isPalindrome(String s, int i, int j) {
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
*/