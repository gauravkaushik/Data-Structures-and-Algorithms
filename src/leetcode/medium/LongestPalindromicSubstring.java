package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/longest-palindromic-substring/
========================================================================

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        int N = s.length();
        
        boolean[][] dp = new boolean[N][N];
        
        //dp[N-1][N-1] = true;
        int windowSize = 0;
        int windowStart=0, windowEnd=0;
        
        for(int i=0; i<N; i++)
        {
            dp[i][i] = true;
        }
        
        for(int i=N-2; i>=0; i--)
        {
            for(int j=i+1; j<N; j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {                       
                    if(j==i+1 || dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                        if( windowSize < (j-i+1) )
                        {
                            windowSize = j-i+1;
                            windowStart = i;
                            windowEnd = j;
                        }
                    }
                }
            }
        }
        
        // for(int i=0; i<N; i++)
        // {
        //     System.out.println();
        //     for(int j=0; j<N; j++)
        //     {
        //         System.out.print(dp[i][j]+", ");
        //     }
        // }
        
        return s.substring(windowStart, windowEnd+1);
        
    }
    
    
}

/* Approach 4: Expand Around Center from https://leetcode.com/problems/longest-palindromic-substring/solution/ : 
public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) return "";
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i);
        int len2 = expandAroundCenter(s, i, i + 1);
        int len = Math.max(len1, len2);
        if (len > end - start) {
            start = i - (len - 1) / 2;
            end = i + len / 2;
        }
    }
    return s.substring(start, end + 1);
}

private int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
        L--;
        R++;
    }
    return R - L - 1;
}

*/