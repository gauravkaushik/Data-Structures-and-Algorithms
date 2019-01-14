package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/delete-operation-for-two-strings/
========================================================================

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

Note:
The length of given words won't exceed 500.
Characters in given words can only be lower-case letters.
*/

public class DeleteOperationForTwoStrings {
    public int minDistance(String A, String B) {
        
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
                    dp[i][j] = Math.min( dp[i][j-1] , dp[i-1][j] ) + 1;
                //System.out.println("dp["+i+"]["+j+"] : "+dp[i][j]);
            }
        
        return dp[m][n];
        
    }
}