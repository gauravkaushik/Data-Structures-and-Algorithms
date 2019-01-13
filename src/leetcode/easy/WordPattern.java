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
https://leetcode.com/problems/word-pattern/
========================================================================

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:
Input: pattern = "abba", str = "dog cat cat dog"
Output: true

Example 2:
Input:pattern = "abba", str = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false

Example 4:
Input: pattern = "abba", str = "dog dog dog dog"
Output: false

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        
        if( (pattern==null && str!=null) || (pattern!=null && str==null) )
            return false;
        
        Map<Character, String> mp1 = new HashMap<>();
        
        Map<String, Character> mp2 = new HashMap<>();
        
        String[] words = str.split(" ");
        
        if(pattern.length() != words.length)
            return false;
        
        char c;
        String temp;
        for(int i=0; i<pattern.length(); i++)
        {
            c = pattern.charAt(i);
            temp = words[i];
            
            if(mp1.containsKey(c) && !mp1.get(c).equals(temp))
                return false;
            
            if(mp2.containsKey(temp) && mp2.get(temp)!=c)
                return false;
            
            mp1.put(c,temp);
            mp2.put(temp,c);           
        }
        
        return true;
    }
}