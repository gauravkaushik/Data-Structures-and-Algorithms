package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/long-pressed-name/
========================================================================

Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 

Example 1:
Input: name = "alex", typed = "aaleex"
Output: true
Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
Input: name = "saeed", typed = "ssaaedd"
Output: false
Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:
Input: name = "leelee", typed = "lleeelee"
Output: true

Example 4:
Input: name = "laiden", typed = "laiden"
Output: true
Explanation: It's not necessary to long press any character.
 

Note:
name.length <= 1000
typed.length <= 1000
The characters of name and typed are lowercase letters.
*/

public class LongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if(name==null && typed==null)
            return true;
        if(name==null || typed==null)
            return false;
        if(name.isEmpty() && typed.isEmpty())
            return true;
        
        char[] nameAry = name.toCharArray();
        char[] typedAry = typed.toCharArray();
        
        int i=0,j=0;
        char prev;
        char cur;
        int count1=1;
        int count2=1;
        while(i<nameAry.length && j<typedAry.length)
        {
            if(nameAry[i] != typedAry[j])
                return false;
            
            while(i+1<nameAry.length && nameAry[i]==nameAry[i+1])
            {
                count1++;
                i++;
            }
            
            while(j+1<typedAry.length && typedAry[j]==typedAry[j+1])
            {
                count2++;
                j++;
            }
            
            if(count1 > count2)
                return false;
            count1 = 1;
            count2 = 1;
            i++;
            j++;
        }
        
        if(i==nameAry.length && j==typedAry.length)        
            return true;
        else
            return false;
        
    }
}