package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/longest-palindrome/
========================================================================

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        Map<Character, Integer> mp = new HashMap<>();
        for(Character c : s.toCharArray())
        {
            mp.put( c, mp.getOrDefault(c, 0) + 1 );
        }
        
        int result = 0;
        boolean isOddCount = false;
        
        for(Integer count : mp.values())
        {            
            if( count % 2 == 0)
                result += count;
            else
            {
                result += (count - 1);
                isOddCount = true;
            }
        }
        
        if(isOddCount)
            result += 1;
        
        return result;
    }
    
    
}