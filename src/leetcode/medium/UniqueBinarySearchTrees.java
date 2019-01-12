package leetcode.medium;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/unique-binary-search-trees/
========================================================================

Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
*/
public class UniqueBinarySearchTrees {
    
    //Key Observation : The solution depends upon number of elements and not on the elements themselves
    //If we know the solution for 0 and 1 element, we can easily find the solution for 2 elements
    //Similarly, if we know the solution for 0,1,2 elements, we can find the solution for 3 elements.. We will pick any one element as root (3 ways) and use the solution for 0,1 or 2 elements as needed { root is 0:(ways = 1 * 2) + root is 1:(ways = 1 * 1) + root is 2:(ways = 2 * 1) } = 2+1+2=5 ways
    public int numTrees(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        if(n <= 1)
            return dp[n];
        
        
        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=i; j++)
            {                
                dp[i] += (dp[get(1,j-1)]) * (dp[get(j+1,i)]);                
            }
        }
        
        return dp[n];
        
    }
    
    private int get(int i, int j)
    {
        return (i > j ? 0 : Math.abs(i-j)+1 );
    }
    
    /* Concise solution from leetcode discussions : 
    dp[2] = 2 ;
    for( int i=3 ; i<=n ; i++ ){
        for( int j=0 ; j<i ; j++ ){
            dp[i] += dp[j] * dp[i-1-j];
        }
    }
    */
}