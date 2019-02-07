package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/longest-substring-without-repeating-characters/
========================================================================

Given a string, find the length of the longest substring without repeating characters.

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

public class LongestSubstringWithoutRepeatingCharacters {
    
    //More efficient version : no need to delete characters from hashmap
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;        
        
        Map<Character, Integer> mp = new HashMap<>();
        int i = 0, j = 0;
        int result = 0;
        
        for(; j<s.length(); j++)
        {
            char c = s.charAt(j);
            if(mp.containsKey(c))
            {
                result = Math.max(result, j-i);
                i = Math.max(i, mp.get(c)+1); //i can only increase
            }            
            mp.put(c,j);
        }        
        
        result = Math.max(result, j-i);
        return result;       
    }
    
    /** This version deletes characters from the hashmap : 
    public int lengthOfLongestSubstring(String s) {
        if(s == null)
            return 0;
        
        //eg : "dvdf", "aabaab!bb"
        //store character and its position in a hashmap
        //keep a variable that points to location of first character in current window
        //once a duplicate character is found, update result if current window size is bigger 
        //remove all characters of current window that are before the position of dup char
        //update window size by subtracting the num of chars removed
        
        Map<Character, Integer> mp = new HashMap<>();
        int windowStart = 0;
        int windowSize = 0;
        int maxWindowSize = 0;
        
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(mp.containsKey(c))
            {
                maxWindowSize = Math.max(maxWindowSize, windowSize);
                //find last position of the duplicate character
                int prevPosDupChar = mp.get(c);
                
                //remove all characters of current window that fall before duplicate character
                for(int j=windowStart; j<prevPosDupChar; j++)
                {
                    mp.remove(s.charAt(j));
                    windowSize--;
                }
                
                //update position of the dup char to current index
                mp.put(c, i);
                
                //reset start of window
                windowStart = prevPosDupChar+1;
            }
            else
            {
                mp.put(c,i);
                windowSize++;                
            }
        }
        
        maxWindowSize = Math.max(maxWindowSize, windowSize);
        return maxWindowSize;        
        
    }
    */
}