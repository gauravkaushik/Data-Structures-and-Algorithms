package leetcode.hard;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/edit-distance/
========================================================================

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')


Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')

*/

public class EditDistance {
    public int minDistance(String A, String B) {
		
        //char[] A = word1.toCharArray();
        //char[] B = word2.toCharArray();
        
        int m = (A!=null ? A.length() : 0);
        int n = (B!=null ? B.length() : 0);
        
        if(m==0)
            return n;
        if(n==0)
            return m;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m; i++)
            dp[i][0] = i;
        
        for(int j=0; j<=n; j++)
            dp[0][j] = j;
        
        for(int i=1; i<=m; i++)
            for(int j=1; j<=n ;j++)
            {
                if(A.charAt(i-1) == B.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                //System.out.println("dp["+i+"]["+j+"] : "+dp[i][j]);
            }
        
        return dp[m][n];
    }
}