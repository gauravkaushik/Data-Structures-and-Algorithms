package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/length-of-last-word/
========================================================================

Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:
Input: "Hello World"
Output: 5
*/

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(s==null || s.length()==0)
            return 0;        
        
        int lastLen = 0;
        int curLen = 0;
        
        for(int i=0; i<s.length(); i++)
        {            
            if(s.charAt(i)!=' ')
            {
                curLen = curLen+1;                
            }
            else
            {
                if(curLen > 0)
                    lastLen = curLen;
                curLen = 0;
            }            
        }        
        
        if(curLen > 0)
            lastLen = curLen;
        
        return lastLen;
    }
    
    /* Concise solution from : https://leetcode.com/problems/length-of-last-word/discuss/21878/A-single-line-of-Code-in-Java
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arrs = s.split(" ");
        return arrs.length==0 ? 0 : arrs[arrs.length - 1].length();
    }
    */
}