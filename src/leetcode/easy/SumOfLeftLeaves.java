package leetcode.easy;

/**
@author :
		Gaurav Kaushik
		https://leetcode.com/kaushikgaurav08/
		https://www.linkedin.com/in/gvk28/ 		
        https://github.com/gauravkaushik
        
========================================================================
https://leetcode.com/problems/sum-of-left-leaves/
========================================================================

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/


public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        
        if(root == null)
            return 0;
        
        return helper(root, root);
    }
    
    private int helper(TreeNode parent, TreeNode cur)
    {   
        //get left leaves' sum in left subtree
        //get left leaves' sum in right subtree
        //return addition of two
        
        if(cur.left==null && cur.right==null) //leaf node
            return (parent.left == cur ? cur.val : 0);        
        int sum = 0;
        if(cur.left != null)
            sum = helper(cur, cur.left);
        if(cur.right != null)
            sum += helper(cur, cur.right);
        return sum;
        
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}