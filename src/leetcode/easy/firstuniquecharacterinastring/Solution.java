package leetcode.easy.firstuniquecharacterinastring;

/**
 @author :
 		Gaurav Kaushik
 		https://leetcode.com/kaushikgaurav08/
 		https://www.linkedin.com/in/gvk28/ 		
 * 
 * 
==========================================================================
https://leetcode.com/problems/first-unique-character-in-a-string/
==========================================================================
 
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
	
 *
 */
public class Solution {
	
    public int firstUniqChar(String s) {        
                
        int[] repeated = new int[26];
        
        char[] letters = s.toCharArray();        
        
        for(char letter : letters)
        {
            repeated[letter - 'a'] += 1;            
        }
        
        int index=0;
        for(char letter:letters)
        {
            if(repeated[letter-'a']==1)
                return index;
            index++;
        }
        return -1;
        
    }
}
