package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/valid-palindrome/
========================================================================

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false
*/

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1)
            return true;       
        
        int i = 0;
        int j = s.length() - 1;
        char x,y;
        boolean xValid = false, yValid  = false;
        while(i < j)
        {
            xValid = true;
            yValid = true;
            
            x = Character.toLowerCase(s.charAt(i));
            y = Character.toLowerCase(s.charAt(j));
            
            xValid = isValid(x);
            yValid = isValid(y);
            
            if(xValid && yValid )
            {
                if( x !=y )
                    return false;
                i++; j--;                    
            } 
            else if(!xValid && !yValid)
            {
                i++;
                j--;
            }
            else if(!xValid)
            {
                i++;
            }
            else
            {
                j--;
            }            
        }
        
        return true;        
    }
    
    private boolean isValid(char c)
    {
        if(c>='a' && c<='z')        
            return true;
        else if(c>='0' && c<='9')
            return true;
        return false;        
    }
}
