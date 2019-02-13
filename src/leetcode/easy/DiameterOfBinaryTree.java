package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/diameter-of-binary-tree/
========================================================================

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if( (root == null) || (root.left==null && root.right==null))
           return 0;
        
        int[] res = {0};
        
        helper(root, res);
        
        return res[0];
    }
    
    private int helper(TreeNode root, int[] res)
    {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)
            return 1;
        
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        
        res[0] = Math.max(res[0], left + right);
        return Math.max(left, right) + 1;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    
}