package leetcode.hard;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/binary-tree-maximum-path-sum/
========================================================================

Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:
Input: [1,2,3]

       1
      / \
     2   3

Output: 6

Example 2:
Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42
*/
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] sumCrossOverRoot = {Integer.MIN_VALUE};
        int[] res = helper(root, sumCrossOverRoot);
        
        //res[0] -> max path sum excluding root
        //res[1] -> max path sum including root
        return Math.max(sumCrossOverRoot[0], Math.max(res[0],res[1]));
    }
    
    private int[] helper(TreeNode root, int[] sumCrossOverRoot)
    {
        if(root == null)
            return new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE};
       
        if(root.left==null && root.right==null)
            return new int[]{root.val, root.val};
       
        int[] left = helper(root.left,sumCrossOverRoot);
        int[] right = helper(root.right,sumCrossOverRoot);
        
        int[] res = new int[2];
        
        int excludeRoot = Math.max(left[0],left[1]);
        excludeRoot = Math.max(excludeRoot, Math.max(right[0],right[1]));        
        res[0] = excludeRoot;
        
        Long includeRoot = new Long(root.val);
        includeRoot = Math.max(includeRoot, left[1]+(long)root.val);
        includeRoot = Math.max(includeRoot, (long)root.val+right[1]);        
        res[1] = getValidInt(includeRoot);
        
        Long includeLeftRootRight = new Long(left[1]+(long)root.val+right[1]);
        sumCrossOverRoot[0] = Math.max(sumCrossOverRoot[0], getValidInt(includeLeftRootRight));
        
        return res;        
        
    }
    
    int getValidInt(Long val)
    {
        int res = (int)(long)val;
        
        //Long minInt = new Long(Integer.MIN_VALUE);
        //Long maxInt = new Long(Integer.MAX_VALUE);
        
        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        
        if(val <= minInt)
            res = minInt;
        if(val >= maxInt)
            res = maxInt;
        return res;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}




/*
A concise solution from leetcode discussion section:

class Solution {
    int max;    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    public int dfs(TreeNode node){
        if(node == null)return 0;
        int left = Math.max(0, dfs(node.left));
        int right =Math.max(0, dfs(node.right));
        max = Math.max(max, node.val + left + right);
        return Math.max(left,right) + node.val;
    }
}

*/